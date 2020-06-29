package com.revature.TourDeFranceShop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.TourDeFranceShop.model.User;
import com.revature.TourDeFranceShop.service.ConnectionService;

public class LoginDB {
	private static final Logger logger = LogManager.getLogger(CustomerDB.class);
	public List<User> login(User user) {
		String username = user.getUsername();
		String passwd = user.getPassword();;
		List<User> userList = new ArrayList<>();
		try {
			Statement s = ConnectionService.dbConnect().createStatement();
			s.executeQuery("SELECT username, role, uid FROM public.users WHERE passwd='"+ passwd+"' AND username='"+ username+"';");
			ResultSet results = s.getResultSet();
			while (results.next()) {
				User newUser = new User();
				newUser.setUsername(results.getString("username"));
				newUser.setRole(results.getString("role"));
				newUser.setUid(results.getInt("uid"));

				userList.add(newUser);
			}
		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
		return userList;
	}

}
