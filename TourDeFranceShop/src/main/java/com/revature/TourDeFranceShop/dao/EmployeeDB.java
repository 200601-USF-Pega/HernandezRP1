package com.revature.TourDeFranceShop.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.TourDeFranceShop.model.Bike;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import com.revature.TourDeFranceShop.model.Bill;
import com.revature.TourDeFranceShop.model.Product;
import com.revature.TourDeFranceShop.service.ConnectionService;

public class EmployeeDB {
	private static final Logger logger = LogManager.getLogger(EmployeeDB.class);

	// Methods that retrieve data from DB
	public List<Bike> getRepairList() {
		List<Bike> repairList = new ArrayList<>();
		try {
			Statement s = ConnectionService.dbConnect().createStatement();
			s.executeQuery("SELECT repairid, bikeid, status FROM public.repair;");
			ResultSet results = s.getResultSet();
			while (results.next()) {
				Bike bike = new Bike();
				bike.setRepairId(results.getInt("repairid"));
				bike.setBikeId(results.getInt("bikeid"));
				bike.setStatus(results.getString("status"));

				repairList.add(bike);
			}
		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
		return repairList;
	}

	public List<Bill> getBillList() {
		List<Bill> statements = new ArrayList<>();
		try {
			Statement s = ConnectionService.dbConnect().createStatement();
			s.executeQuery("SELECT billid, balance, status, bikeid  FROM public.bills;");
			ResultSet results = s.getResultSet();
			while (results.next()) {
				Bill bill = new Bill();
				bill.setBillId(results.getInt("billid"));
				bill.setBalance(results.getDouble("balance"));
				bill.setStatus(results.getString("status"));
				bill.setBikeId(results.getInt("bikeid"));

				statements.add(bill);
			}

		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
		return statements;
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
	
	//Methods that remove data from DB
	public void removeRepairEntry(Bike bike) {
		int repairId = bike.getRepairId();
		try {
			Statement s = ConnectionService.dbConnect().createStatement();
			s.executeQuery("DELETE FROM public.repair WHERE repairid =" + repairId+";");
		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
		
	}

	// Methods that insert data to DB
	public void insertBalance(Bill bill) {
		int customerId = bill.getUserId();
		int bikeId = bill.getBikeId();
		double balance = bill.getBalance();

		try {
			PreparedStatement s = ConnectionService.dbConnect()
					.prepareStatement("INSERT INTO public.bills (balance, status, uid, bikeid)" + "VALUES (?,?,?,?);");
			s.setDouble(1, balance);
			s.setString(2, "unpaid");
			s.setInt(3, customerId);
			s.setInt(4, bikeId);
			s.executeUpdate();
		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
	}

	public void insertProduct(Product product) {
		String name = product.getName();
		double price = product.getPrice();
		String desc = product.getDesc();
		try {
			PreparedStatement s = ConnectionService.dbConnect().prepareStatement(
					"INSERT INTO public.products (name, price, description, status)" + "VALUES (?,?,?,?);");
			s.setString(1, name);
			s.setDouble(2, price);
			s.setString(3, desc);
			s.setString(4, "in stock");
			s.executeUpdate();
		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
	}

	// Methods that update data in DB
	public void updateRepairStatus(Bike bike) {
		int repairId = bike.getRepairId();
		String status = bike.getStatus();
		try {
			PreparedStatement s = ConnectionService.dbConnect().prepareStatement(
					"UPDATE public.repair SET status='" + status + "'" + "WHERE repairid=" + repairId);
			s.executeUpdate();
		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
	}

	public void updateBillStatus(Bill bill) {
		int billId = bill.getBillId();
		String status = bill.getStatus();
		try {
			PreparedStatement s = ConnectionService.dbConnect()
					.prepareStatement("UPDATE public.bills SET status='" + status + "'" + "WHERE billid=" + billId);
			s.executeUpdate();
		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
	}

	public void updateProduct(Product product) {
		int productId = product.getProductId();
		String status = product.getStatus();
		double price = product.getPrice();
		if (status != "" && price > 0) {
			try {
				PreparedStatement s = ConnectionService.dbConnect().prepareStatement(
						"UPDATE public.products SET status='" + status + "', price='"+ price + "' WHERE pid=" + productId);
				s.executeUpdate();
			} catch (SQLException e) {
				logger.error("Exception: " + e.getMessage());
			}
		} else if (status != "") {
			try {
				PreparedStatement s = ConnectionService.dbConnect().prepareStatement(
						"UPDATE public.products SET status='" + status + "'" + "WHERE pid=" + productId);
				s.executeUpdate();
			} catch (SQLException e) {
				logger.error("Exception: " + e.getMessage());
			}
		} else {
			updateProductPrice(productId, price);
		}

	}

	public void updateProductPrice(int productId, double price) {
		try {
			PreparedStatement s = ConnectionService.dbConnect()
					.prepareStatement("UPDATE public.products SET price='" + price + "'" + "WHERE pid=" + productId);
			s.executeUpdate();
		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
	}

	// Logout
	public void logout() {
		logger.info("Employee logged out");
	}
}
