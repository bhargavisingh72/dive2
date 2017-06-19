package com.model;

import java.util.logging.Logger;

public class BookSales {
	private static final Logger LOGGER = Logger.getLogger(BookSales.class.getName());
	private int salesid;
	private int userid;
	private int bookid;
	private int quantity;
	private int totalamount;
	private int orderdate;
		public int getSalesid() {
		return salesid;
	}
	public void setSalesid(int salesid) {
		this.salesid = salesid;
	}
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}
	public int getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(int orderdate) {
		this.orderdate = orderdate;
	}
	
	public String toString()
 	{
 		return salesid+" "+userid+" "+bookid+" "+quantity+" "+totalamount+" "+orderdate;
 	}
}
