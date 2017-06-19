package com.dao;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.connectionutil.ConnectionUtil;
import com.model.UserModel;

public class UserDao {
	private static final Logger LOGGER = Logger.getLogger( UserDao.class.getName() );

	private JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	
	public List<UserModel> findAll(){

		String sql = "SELECT * FROM USER";

		List<UserModel> usermodel  = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper(UserModel.class));

		return usermodel;
	}
	
	/*public int findTotalUser(){

		String sql = "SELECT COUNT(*) FROM USER";

		int total = jdbcTemplate.queryForInt(sql);

		return total;
	}*/
	
	public void saveOrUpdate(UserModel usermodel) {
	    if (usermodel.getId() < 0) {
	        // update
	        String sql = "UPDATE USER SET name=?, username=?, password=?, "
	                    + " WHERE id=?";
	        jdbcTemplate.update(sql, usermodel.getName(), usermodel.getUsername(),
	        		usermodel.getPassword(),usermodel.getId());
	    } else {
	        // insert
	        String sql = "INSERT INTO USER (id,name,username,password,mobileno,emailid,active,role)"
	                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        jdbcTemplate.update(sql, usermodel.getId(), usermodel.getName(),
	        		usermodel.getUsername(),usermodel.getPassword(),usermodel.getMobileno(),
	        		usermodel.getEmailid(),usermodel.getActive(),usermodel.getRole());
	    }
	 
	}
	
	public void delete(int id) {
	    String sql = "DELETE FROM USER WHERE id=?";
	    jdbcTemplate.update(sql, id);
	    
	    LOGGER.info("Successfully deleted");
	}
}