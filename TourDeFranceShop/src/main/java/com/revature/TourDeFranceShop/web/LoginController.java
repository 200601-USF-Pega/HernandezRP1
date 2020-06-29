package com.revature.TourDeFranceShop.web;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.TourDeFranceShop.dao.LoginDB;
import com.revature.TourDeFranceShop.model.User;

@Path("/loginservice")
public class LoginController {

	LoginDB signin = new LoginDB();

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(User user) {
		return Response.ok((ArrayList<User>) signin.login(user)).build();
	}
}
