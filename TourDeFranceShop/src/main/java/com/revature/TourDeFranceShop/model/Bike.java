package com.revature.TourDeFranceShop.model;

public class Bike {
	private String model;
	private String status; 
	private int bikeId;
	private int repairId = 0; //Default value if registered bike doesn't need repair
	private int uId; 
	
	
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
	public int getRepairId() {
		return repairId;
	}
	public void setRepairId(int repairId) {
		this.repairId = repairId;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	
	@Override
	public String toString() {
		return "Bike [model=" + model + ", status=" + status + ", bikeId=" + bikeId + ", repairId=" + repairId + "]";
	}
	
}
