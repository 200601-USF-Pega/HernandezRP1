package com.revature.TourDeFranceShop.model;

public class Product {
	private String name;
	private String desc;
	private double price;
	private int productId;

	//Setters and Getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", desc=" + desc + ", price=" + price + ", productId=" + productId + "]";
	}
}
