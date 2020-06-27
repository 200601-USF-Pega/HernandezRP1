package com.revature.TourDeFranceShop.model;

public class Bill {
	private String status;
	private double balance;
	private int billId;
	private int userId;
	private int bikeId;
	
	// Setters and Getters
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBikeId() {
		return bikeId;
	}
	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}
	@Override
	public String toString() {
		return "Bill [status=" + status + ", balance=" + balance + ", billId=" + billId + "]";
	}
	
}
