package com.revature.TourDeFranceShop.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import com.revature.TourDeFranceShop.model.Bill;
import com.revature.TourDeFranceShop.service.ConnectionService;

public class EmployeeDB {
	//private static final Logger logger = LogManager.getLogger(EmployeeDB.class);

	// Methods that retrieve data from DB
	public List<String> getRepairList() {
		List<String> repairList = new ArrayList<>();
		try {
			Statement s = ConnectionService.dbConnect().createStatement();
			s.executeQuery("SELECT repairid, bikeid, status FROM public.repair;");
			ResultSet results = s.getResultSet();
			while (results.next()) {
				repairList.add(results.getString("repairid"));
				repairList.add(results.getString("bikeid"));
				repairList.add(results.getString("status"));
			}
		} catch (SQLException e) {
			//logger.error("Exception: " + e.getMessage());
		}
		return repairList;
	}

	public List<Bill> getBill() {
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
			//logger.error("Exception: " + e.getMessage());
		}
		return statements;
	}

	public List<String> getProductList() {
		List<String> products = new ArrayList<>();
		try {
			Statement s = ConnectionService.dbConnect().createStatement();
			s.executeQuery("SELECT * FROM public.products;");
			ResultSet results = s.getResultSet();
			while (results.next()) {
				products.add(results.getString("pid"));
				products.add(results.getString("name"));
				products.add(results.getString("price"));
				products.add(results.getString("description"));
				products.add(results.getString("status"));
			}
		} catch (SQLException e) {
			//logger.error("Exception: " + e.getMessage());
		}
		return products;
	}

	// Methods that insert data to DB
	public void insertBalance(int customerId, int bikeId, double balance) {
		try {
			PreparedStatement s = ConnectionService.dbConnect()
					.prepareStatement("INSERT INTO public.bills (balance, status, uid, bikeid)" + "VALUES (?,?,?,?);");
			s.setDouble(1, balance);
			s.setString(2, "unpaid");
			s.setInt(3, customerId);
			s.setInt(4, bikeId);
			s.executeUpdate();
		} catch (SQLException e) {
			//logger.error("Exception: " + e.getMessage());
		}
	}

	public void insertProduct(String name, double price, String desc) {
		try {
			PreparedStatement s = ConnectionService.dbConnect().prepareStatement(
					"INSERT INTO public.products (name, price, description, status)" + "VALUES (?,?,?,?);");
			s.setString(1, name);
			s.setDouble(2, price);
			s.setString(3, desc);
			s.setString(4, "in stock");
			s.executeUpdate();
		} catch (SQLException e) {
			//logger.error("Exception: " + e.getMessage());
		}
	}

	// Methods that update data in DB
	public void updateRepairStatus(int repairId, String status) {
		try {
			PreparedStatement s = ConnectionService.dbConnect().prepareStatement(
					"UPDATE public.repair SET status='" + status + "'" + "WHERE repairid=" + repairId);
			s.executeUpdate();
		} catch (SQLException e) {
			//logger.error("Exception: " + e.getMessage());
		}
	}

	public void updateBillStatus(int billId, String status) {
		try {
			PreparedStatement s = ConnectionService.dbConnect()
					.prepareStatement("UPDATE public.bills SET status='" + status + "'" + "WHERE billid=" + billId);
			s.executeUpdate();
		} catch (SQLException e) {
			//logger.error("Exception: " + e.getMessage());
		}
	}

	public void updateProductStatus(int productId, String status) {
		try {
			PreparedStatement s = ConnectionService.dbConnect()
					.prepareStatement("UPDATE public.products SET status='" + status + "'" + "WHERE pid=" + productId);
			s.executeUpdate();
		} catch (SQLException e) {
			//logger.error("Exception: " + e.getMessage());
		}
	}

	public void updateProductPrice(int productId, double price) {
		try {
			PreparedStatement s = ConnectionService.dbConnect()
					.prepareStatement("UPDATE public.products SET price='" + price + "'" + "WHERE pid=" + productId);
			s.executeUpdate();
		} catch (SQLException e) {
			//logger.error("Exception: " + e.getMessage());
		}
	}

	// Logout
	public void logout() {
		//logger.info("Employee logged out");
	}
}
