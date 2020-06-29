package com.revature.TourDeFranceShop.model;

import static org.junit.Assert.*;

import org.junit.*;

public class BikeTest {
	Bike bikeTest;
	
	@Before
	public void dummyData() {
		bikeTest = new Bike();
		bikeTest.setModel("trek45ig");
		bikeTest.setStatus("Complete");
		bikeTest.setuId(2);
	}
	
	@Test
	public void bikeModelSholdBetrek45ig() {
		assertEquals("trek45ig", bikeTest.getModel());
	}
	
	@Test 
	public void bikeStatusShouldBeComplete() {
		assertEquals("Complete", bikeTest.getStatus());
	}
	
	@Test 
	public void shouldBeTypeMismatch() {
		assertNotEquals(2, bikeTest.getStatus());
	}
}
