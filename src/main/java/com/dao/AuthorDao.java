package com.dao;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.connectionutil.ConnectionUtil;
import com.model.AuthorModel;
import com.model.UserModel;

public class AuthorDao {
	private static final Logger LOGGER = Logger.getLogger(AuthorDao.class.getName() );

	private JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	
	public List<AuthorModel> findAll(){

		String sql = "SELECT * FROM BOOK";

		List<AuthorModel> authormodel  = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper(AuthorModel.class));

		return authormodel ;
	}
	
	/*public int findTotalBook(){

		String sql = "SELECT COUNT(*) FROM BOOK";

		int total = jdbcTemplate.queryForInt(sql);

		return total;
	}*/
	
	public void saveOrUpdate(AuthorModel authormodel) {
	    if (authormodel.getIsbn() < 0) {
	        // update
	        String sql = "UPDATE BOOK SET author=?, content=?, title=?, "
	                    + " WHERE isbn=?";
	        jdbcTemplate.update(sql, authormodel.getAuthor(), authormodel.getContent(),
	        		authormodel.getTitle(),authormodel.getIsbn());
	    } else {
	        // insert
	        String sql = "INSERT INTO BOOK (isbn,author,content,price,title,publishdate,status)"
	                    + " VALUES (?, ?, ?, ?, ?, ?, ? )";
	        jdbcTemplate.update(sql, authormodel.getIsbn(), authormodel.getAuthor(),authormodel.getContent(),
	        		authormodel.getPrice(),authormodel.getTitle(),authormodel.getPublishdate(),
	        		authormodel.getStatus());
	    }
	 
	}
	
	public void delete(int isbn) {
	    String sql = "DELETE FROM BOOK WHERE isbn=?";
	    jdbcTemplate.update(sql, isbn);
	    
	    LOGGER.info("Successfully deleted");
	}
}
