package org.market.types;

public class GoodsType {
	private int GNO;
	private String name;
	private int owner;
	private double price;
	private String image;
	private int mainClass;
	private int subClass;
	private String introduction;
	private String date;
	private String label;
	
	public GoodsType(){
		super();
	}
	public GoodsType(String name,int owner,double price,String image,
			int mainClass,int subClass,String introduction,String date){
		this.name = name;
		this.owner = owner;
		this.price = price;
		this.image = image;
		this.mainClass = mainClass;
		this.subClass = subClass;
		this.introduction = introduction;
		this.date = date;
	}
	public int getGNO(){
		return GNO;
	}
	public void setGNO(int GNO){
		this.GNO = GNO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getMainClass() {
		return mainClass;
	}
	public void setMainClass(int mainClass) {
		this.mainClass = mainClass;
	}
	public int getSubClass() {
		return subClass;
	}
	public void setSubClass(int subClass) {
		this.subClass = subClass;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
