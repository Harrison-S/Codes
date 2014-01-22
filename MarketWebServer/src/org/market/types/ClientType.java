package org.market.types;

public class ClientType {
	private int CNO;
	private String name;
	private String password;
	private int gender;
	private String stuNO;
	private String phone;
	private String email;
	private String date;
	
	public ClientType(){
		super();
	}
	public ClientType(String name,String password){
		this.name = name;
		this.password = password;
		this.gender = 0;
		this.stuNO = this.phone = this.email = this.date = "";
	}
	public ClientType(String name,String password,int gender,String stuNO,String phone,String email,String date){
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.stuNO = stuNO;
		this.phone = phone;
		this.email = email;
		this.date = date;
	}
	public int getCNO() {
		return CNO;
	}
	public void setCNO(int CNO){
		this.CNO = CNO;
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
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getStuNO() {
		return stuNO;
	}
	public void setStuNO(String stuNO) {
		this.stuNO = stuNO;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
