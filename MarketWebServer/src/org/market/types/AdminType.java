package org.market.types;

public class AdminType {
	private String name;
	private String password;
	private String date;
	
	public AdminType(){
		super();
	}
	public AdminType(String name,String password){
		this.name = name;
		this.password = password;
		this.date = null;
	}
	public AdminType(String name,String password,String date){
		this.name = name;
		this.password = password;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
