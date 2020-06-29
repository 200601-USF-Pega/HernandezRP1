package com.revature.TourDeFranceShop.model;

import static org.junit.Assert.*;

import org.junit.*;

public class BillTest {
	Bill billTest;
	@Before
	public void dummyData() {
		billTest = new Bill();
		billTest.setBikeId(1);
		billTest.setBillId(2);
		billTest.setStatus("pending");
	}
	
	@Test
	public void billBikeIdShouldMatch() {
		assertEquals(1, billTest.getBikeId());
	}
	
	@Test 
	public void billBillIdShouldMatch() {
		assertEquals(2, billTest.getBillId());
	}
	
	@Test 
	public void billStatusShouldMatch() {
		assertEquals("pending", billTest.getStatus());
	}
}
