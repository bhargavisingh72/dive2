package com.model;

import java.util.logging.Logger;

public class UserModel {
	private static final Logger LOGGER = Logger.getLogger(UserModel.class.getName());
	private int id;
private String name;
private String username;
private String password;
private int mobileno;
private String emailid;
private String active;
private String role;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getMobileno() {
	return mobileno;
}
public void setMobileno(int mobileno) {
	this.mobileno = mobileno;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getActive() {
	return active;
}
public void setActive(String active) {
	this.active = active;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String toString()
	{
		return id+" "+name+" "+username+" "+password+" "+mobileno+" "+emailid+" "+active+" "+role;
	}
}
