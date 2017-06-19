package com.dao;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.connectionutil.ConnectionUtil;
import com.model.InventoryModel;

public class InventoryDao {
	private static final Logger LOGGER = Logger.getLogger(InventoryDao.class.getName() );

	private JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	public List<InventoryModel> findAll(){

		String sql = "SELECT * FROM BOOKINVENTORY";

		List<InventoryModel> bookin  = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper(InventoryModel.class));

		return bookin;
	}
	
	/*public int findTotalBookInventory(){

		String sql = "SELECT COUNT(*) FROM BOOKINVENTORY";

		int total = jdbcTemplate.queryForInt(sql);

		return total;
	}*/
	
	public void saveOrUpdate(InventoryModel bookin) {
	    if (bookin.getBookid() < 0) {
	        // update
	        String sql = "UPDATE BOOKINVENTORY SET  quantity=? "
	                    + " WHERE bookid=?";
	        jdbcTemplate.update(sql, bookin.getQuantity(), bookin.getBookid());
	    } else {
	        // insert
	        String sql = "INSERT INTO BOOKINVENTORY(bookid,quantity)"
	                    + " VALUES (?, ?)";
	        jdbcTemplate.update(sql, bookin.getBookid(),bookin.getQuantity());
	    }
	 
	}
	
	public void delete(int bookid) {
	    String sql = "DELETE FROM BOOKINVENTORY WHERE bookid=?";
	    jdbcTemplate.update(sql, bookid);
	    
	    LOGGER.info("Successfully deleted");
	}
}
