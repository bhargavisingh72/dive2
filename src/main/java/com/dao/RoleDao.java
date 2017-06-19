package com.dao;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.connectionutil.ConnectionUtil;
import com.model.RoleModel;

public class RoleDao {
	private static final Logger LOGGER = Logger.getLogger( RoleDao.class.getName() );


	private JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	
	public List<RoleModel> findAll(){

		String sql = "SELECT * FROM ROLE";

		List<RoleModel> role  = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper(RoleModel.class));

		return role;
	}
	
	/*public int findTotalRole(){

		String sql = "SELECT COUNT(*) FROM ROLE";

		int total = jdbcTemplate.queryForInt(sql);

		return total;
	}*/
	
	public void saveOrUpdate(RoleModel role) {
	    if (role.getId() < 0) {
	        // update
	        String sql = "UPDATE ROLE SET name=? "
	                    + " WHERE userid=?";
	        jdbcTemplate.update(sql, role.getName(), role.getId());
	    } 
	    else {
	        // insert
	        String sql = "INSERT INTO ROLE (userid,name)"
	                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        jdbcTemplate.update(sql, role.getId(), role.getName());
	    }
	 
	}
	
	public void delete(int userid) {
	    String sql = "DELETE FROM ROLE WHERE userid=?";
	    jdbcTemplate.update(sql, userid);
	    
	    LOGGER.info("Successfully deleted");
	}
}
