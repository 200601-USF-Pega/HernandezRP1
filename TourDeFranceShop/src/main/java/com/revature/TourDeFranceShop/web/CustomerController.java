package com.revature.TourDeFranceShop.web;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;

import com.revature.TourDeFranceShop.dao.CustomerDB;
import com.revature.TourDeFranceShop.model.Bike;
import com.revature.TourDeFranceShop.model.Bill;
import com.revature.TourDeFranceShop.model.Product;


@Path("/customer")
public class CustomerController {
	
	CustomerDB customer = new CustomerDB();
	
	//GET Paths
	@GET
	@Path("/getBill/{uid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBill(@PathParam("uid") String id) {
		return Response.ok((ArrayList<Bill>)customer.getBill(id)).build();
	}
	
	@GET
	@Path("/getRepair/{uid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRepair(@PathParam("uid") String id) {
		return Response.ok((ArrayList<Bike>)customer.getRepairStatus(id)).build();
	}
	
	@GET
	@Path("/getAllProducts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRepair() {
		return Response.ok((ArrayList<Product>)customer.getProductList()).build();
	}
	
	@GET
	@Path("/getProduct/{pid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct(@PathParam("pid") String pid) {
		return Response.ok(customer.getProductById(pid)).build();
	}
	//POST Paths
	@POST
	@Path("/postRegisterBike")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postRegisterBike(Bike bike) {
		return Response.ok(customer.registerBike(bike)).build();
	}
	
	@POST
	@Path("/postPayBill")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postPayBill(Bill bill) {
		customer.payBill(bill);
		return Response.ok().build();
	}
}
