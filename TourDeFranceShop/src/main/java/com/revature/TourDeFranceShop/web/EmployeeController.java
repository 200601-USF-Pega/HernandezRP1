package com.revature.TourDeFranceShop.web;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;

import com.revature.TourDeFranceShop.dao.EmployeeDB;
import com.revature.TourDeFranceShop.model.Bill;

@Path("/employee")
public class EmployeeController {
	
	EmployeeDB employee = new EmployeeDB();
	
	@GET
	@Path("/getAllBills")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBills() {
		return Response.ok((ArrayList<Bill>)employee.getBill()).build();
	}
}
