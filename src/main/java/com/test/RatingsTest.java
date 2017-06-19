package com.test;

import com.dao.RatingsDao;
import com.model.Ratings;

public class RatingsTest {
	public static void main(String args[])
	 {
	 	 RatingsDao ratings= new RatingsDao();
	 		
	 	
	 Ratings cc= new Ratings();
	 		
	 		cc.setUserid(1);
	 		cc.setBookid(3457);
	 		cc.setRating(8);
	 			 }
}
