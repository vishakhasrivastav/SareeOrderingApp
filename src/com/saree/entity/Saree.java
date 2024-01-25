package com.saree.entity;
//first step
public class Saree {
	private String sareeId;
	private String sareeName;
	private String type; //Reguarl ,Partywear,wedding,GirlsWear
	private String category; //Banarasi,mysore silk,kanchipuram,maduvaniprint...
	private Double price;
	private Integer quantityInstock;
	private String color;//red blue green...
	//alt+shift+s
	public Saree() {
		super();
		// TODO Auto-generated constructor stub
	}//Parameterized constructor 
	
	public Saree(String sareeId, String sareeName, String type, String category, Double price, Integer quantityInstock,
			String color) {
		super();
		this.sareeId = sareeId;
		this.sareeName = sareeName;
		this.type = type;
		this.category = category;
		this.price = price;
		this.quantityInstock = quantityInstock;
		this.color = color;
	}

	//getter setter 
	public String getSareeId() {
		return sareeId;
	}
	
	public void setSareeId( String sareeId) {
		this.sareeId = sareeId;
	}
	
	public String getSareeName() {
		return sareeName;
	}
	
	public void setSareeName( String sareeName) {
		this.sareeName = sareeName;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Integer getQuantityInstock() {
		return quantityInstock;
	}
	
	public void setQuantityInstock(Integer quantityInstock) {
		this.quantityInstock = quantityInstock;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override//toString()
	public String toString() {
		return " \n[sareeId=" + sareeId + "\sareeName=" + sareeName + ", type=" + type + "\ncategory=" + category
				+ "\nprice=" + price + "\n quantityInstock=" + quantityInstock + "\ncolor="+color+ "]";
	}
	
	
	
}

