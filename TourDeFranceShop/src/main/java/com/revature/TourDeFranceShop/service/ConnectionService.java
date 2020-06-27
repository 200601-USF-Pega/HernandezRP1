package com.revature.TourDeFranceShop.service;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionService {
	private static Connection connection;
	
	public static void start() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(DBConfig.url, DBConfig.username, DBConfig.password);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static Connection dbConnect() {
		if(connection == null) {
			start();
		}
		return connection;
	}
	
	@Override
	public void finalize() {
		try {
			connection.close();
		} catch(Exception e) {}
	}
}
