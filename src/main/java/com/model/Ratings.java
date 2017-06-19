package com.model;

import java.util.logging.Logger;

public class Ratings {
	private static final Logger LOGGER = Logger.getLogger(Ratings.class.getName());
	private int userid;
 private int bookid;
private int rating;
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}  
public String toString()
	{
		return userid+" "+bookid+" "+rating;
	}
}
