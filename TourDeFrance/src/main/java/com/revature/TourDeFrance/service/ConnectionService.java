package com.revature.TourDeFrance.service;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionService {
	private static Connection connection;
	
	public static void start() {
		try {
			connection = DriverManager.getConnection(DBConfig.url,
							DBConfig.username, DBConfig.password);
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
