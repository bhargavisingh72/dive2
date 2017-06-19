package com.model;

import java.util.logging.Logger;

public class InventoryModel {
	private static final Logger LOGGER = Logger.getLogger(InventoryModel.class.getName());
	private int bookid;
private int quantity;
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
public String toString()
	{
		return bookid+" "+quantity;
	}
}
