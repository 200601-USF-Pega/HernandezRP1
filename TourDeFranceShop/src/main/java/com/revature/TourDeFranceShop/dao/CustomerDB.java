package com.revature.TourDeFranceShop.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.TourDeFranceShop.model.Bike;
import com.revature.TourDeFranceShop.model.Bill;
import com.revature.TourDeFranceShop.model.Product;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import com.revature.TourDeFranceShop.service.ConnectionService;

public class CustomerDB {
	private static final Logger logger = LogManager.getLogger(CustomerDB.class);

	// Methods that retrieve data from DB
	public List<Bike> getRepairStatus(String userId) {
		int uId = Integer.parseInt(userId);
		List<Bike> status = new ArrayList<>();
		try {
			Statement s = ConnectionService.dbConnect().createStatement();
			s.executeQuery("SELECT repairid, bikeid, status FROM public.repair WHERE uid=" + uId + ";");
			ResultSet results = s.getResultSet();
			while (results.next()) {
				Bike bike = new Bike();
				bike.setRepairId(results.getInt("repairid"));
				bike.setBikeId(results.getInt("bikeid"));
				bike.setStatus(results.getString("status"));

				status.add(bike);
			}

		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
		return status;
	}

	public List<Bill> getBill(String userId) {
		int uId = Integer.parseInt(userId);
		List<Bill> statements = new ArrayList<>();
		try {
			Statement s = ConnectionService.dbConnect().createStatement();
			s.executeQuery("SELECT billid, bikeid, balance, status  FROM public.bills WHERE uid=" + uId + ";");
			ResultSet results = s.getResultSet();
			while (results.next()) {
				Bill bill = new Bill();
				bill.setBillId(results.getInt("billid"));
				bill.setBikeId(results.getInt("bikeid"));
				bill.setBalance(results.getDouble("balance"));
				bill.setStatus(results.getString("status"));

				statements.add(bill);
			}

		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
		return statements;
	}

	public String getProductById(String productId) {
		String productName = "";
		int pId = Integer.parseInt(productId);
		try {
			Statement s = ConnectionService.dbConnect().createStatement();
			s.executeQuery("SELECT name FROM public.products WHERE pid=" + pId + ";");
			ResultSet results = s.getResultSet();
			while (results.next()) {
				productName = results.getString("name");
			}

		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
		return productName;
	}

	public List<Product> getProductList() {
		List<Product> productList = new ArrayList<>();
		try {
			Statement s = ConnectionService.dbConnect().createStatement();
			s.executeQuery("SELECT * FROM public.products;");
			ResultSet results = s.getResultSet();
			while (results.next()) {
				Product product = new Product();
				product.setProductId(results.getInt("pid"));
				product.setName(results.getString("name"));
				product.setPrice(results.getDouble("price"));
				product.setDesc(results.getString("description"));
				product.setStatus(results.getString("status"));

				productList.add(product);
			}
		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
		return productList;
	}

	// Methods that insert data to DB

	public String registerBike(Bike bike) {
		try {
			PreparedStatement s = ConnectionService.dbConnect()
					.prepareStatement("INSERT INTO public.bikes (model, uid) VALUES (?, ?);");
			s.setString(1, bike.getModel());
			s.setInt(2, bike.getuId());
			s.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			logger.error("Exception: " + e.getMessage());
		}
		return "Successfully registered your bike (" + bike.getModel() + ")!";

	}

	// Methods that change data in DB
	public void payBill(Bill bill) {
		int billId = bill.getBillId();
		String status = "pending";
		try {
			PreparedStatement s = ConnectionService.dbConnect().prepareStatement(
					"UPDATE public.bills set status='" + status + "'" + "WHERE billid=" + billId + ";");
			s.executeUpdate();
		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
	}

	// Logout
	public void logout() {
		logger.info("Customer logged out");
	}

}
