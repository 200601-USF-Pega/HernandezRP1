package com.revature.TourDeFranceShop.model;

public class Bike {
	private String model;
	private String status; //TODO: possibly remove
	private int bikeId;
	private int uId; //TODO: possible remove
	
	// Setter and Getters
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBikeId() {
		return bikeId;
	}
	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	
	@Override
	public String toString() {
		return "Bike [model=" + model + ", status=" + status + ", bikeId=" + bikeId + ", uId=" + uId + "]";
	}
	
}
