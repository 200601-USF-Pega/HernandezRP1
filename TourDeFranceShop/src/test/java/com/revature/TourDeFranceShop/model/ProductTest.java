package com.revature.TourDeFranceShop.model;

import static org.junit.Assert.*;

import org.junit.*;

public class ProductTest {
	
	Product productTest;
	@Before
	public void dummyData() {
		productTest = new Product();
		productTest.setPrice(10.98);
		productTest.setStatus("in stock");
	}
	
	@Test
	public void productPriceShouldBeDouble() {
		assertEquals(10.98, productTest.getPrice());
	}
	
	@Test 
	public void productStatusShouldBeinstock() {
		assertEquals("in stock", productTest.getStatus());
	}
}
