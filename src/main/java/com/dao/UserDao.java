package com.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.connectionutil.ConnectionUtil;
import com.model.UserModel;


public class UserDao {
	
	final static Logger logger = Logger.getLogger(UserDao.class);
	
	
	public void insertUser(UserModel user) throws Exception {
        
		
		JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
 
        
        String sql = "insert into user (id , name, username , password ,mobile_no , email_ID , active, user_roleId) values (?,?,?,?,?,?,?,?)";
        
        // 3. Set the input and Query execute
        int rows = jdbcTemplate.update(sql, user.getId(), user.getName(), user.getUsername(), user.getPassword(), user.getMobileno(), user.getEmailid(), user.getActive(), user.getRole());
        logger.info("No of rows inserted: " + rows);	
    }
	

	public void loginUser(UserModel user) throws Exception {
		
		JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
		
       
        String sql = "select * from user where (userName= ?) and (password = ?)";
		
        
        List<UserModel>  users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserModel>(UserModel.class), user.getUsername(), user.getPassword());
        logger.info("Login Success ");
        logger.info("User Details : " + users);
	}
	
	
	public void updatePassword(UserModel user, String newPassword) throws Exception {
		
		JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
		
        
		String sql = "update user set password = ? where ((username = ?) and (active = 'A')) and password=?";
		
		
		int rows = jdbcTemplate.update(sql, newPassword, user.getUsername(), user.getPassword());
		System.out.println("No of rows inserted: " + rows);
		if (rows == 1) 	
			logger.info("Password Reset Sucess");
		else if (rows == 0) 
			logger.info("Please Login to reset");
		else 
			logger.info("Error Reset");
	}

}