package com.dao;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.connectionutil.ConnectionUtil;
import com.model.Ratings;

public class RatingsDao {
	private static final Logger LOGGER = Logger.getLogger( RatingsDao.class.getName() );

	private JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	public List<Ratings> findAll(){

		String sql = "SELECT * FROM RATINGS";

		List<Ratings> bookrate  = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper(Ratings.class));

		return bookrate;
	}
	
	/*public int findTotalRatings(){

		String sql = "SELECT COUNT(*) FROM RATINGS";

		int total = jdbcTemplate.queryForInt(sql);

		return total;
	}*/
	
	public void saveOrUpdate(Ratings bookrate) {
	    if (bookrate.getBookid() < 0) {
	        // update
	        String sql = "UPDATE RATINGS SET  userid=?,rating=? "
	                    + " WHERE bookid=?";
	        jdbcTemplate.update(sql, bookrate.getUserid(), bookrate.getRating());
	    } else {
	        // insert
	        String sql = "INSERT INTO RATINGS(bookid,userid,rating)"
	                    + " VALUES (?,?,?)";
	        jdbcTemplate.update(sql, bookrate.getBookid(),bookrate.getUserid(),bookrate.getRating());
	    }
	 
	}
	
	public void delete(int bookid) {
	    String sql = "DELETE FROM RATINGS WHERE bookid=?";
	    jdbcTemplate.update(sql, bookid);
	    
	    LOGGER.info("Successfully deleted");
	}

}
