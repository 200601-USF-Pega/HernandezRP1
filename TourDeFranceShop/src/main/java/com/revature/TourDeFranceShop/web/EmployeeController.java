package com.revature.TourDeFranceShop.web;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;

import com.revature.TourDeFranceShop.dao.EmployeeDB;
import com.revature.TourDeFranceShop.model.Bike;
import com.revature.TourDeFranceShop.model.Bill;
import com.revature.TourDeFranceShop.model.Product;

@Path("/employee")
public class EmployeeController {
	
	EmployeeDB employee = new EmployeeDB();
	
	//GET Paths
	@GET
	@Path("/getAllBills")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBills() {
		return Response.ok((ArrayList<Bill>)employee.getBillList()).build();
	}
	
	@GET
	@Path("/getAllProducts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProducts() {
		return Response.ok((ArrayList<Product>)employee.getProductList()).build();
	}
	
	@GET
	@Path("/getAllRepairs")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRepairs() {
		return Response.ok((ArrayList<Bike>)employee.getRepairList()).build();
	}
	
	//DELETE Paths
	@DELETE
	@Path("/deleteRepairEntry")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteRepairEntry(Bike bike) {
		employee.removeRepairEntry(bike);
		return Response.ok().build();
	}
	
	//POST Paths
	@POST
	@Path("/postEditBill")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postEditBill(Bill bill) {
		employee.updateBillStatus(bill);
		return Response.ok().build();
	}
	
	@POST
	@Path("/postAddBill")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postAddBill(Bill bill) {
		employee.insertBalance(bill);
		return Response.ok().build();
	}
	
	@POST
	@Path("/postEditProduct")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postEditProduct(Product product) {
		employee.updateProduct(product);
		return Response.ok().build();
	}
	
	@POST
	@Path("/postAddProduct")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postAddProduct(Product product) {
		employee.insertProduct(product);
		return Response.ok().build();
	}
	
	@POST
	@Path("/postEditRepair")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postEditRepair(Bike bike) {
		employee.updateRepairStatus(bike);
		return Response.ok().build();
	}
	
}
