package com.revature.TourDeFranceShop.model;

import static org.junit.Assert.*;

import org.junit.*;

public class UserTest {
	
	User testUser;
	
	@Before
	public void dummyData() {
		testUser = new User();
		testUser.setRole("employee");
		testUser.setUsername("jApple");
	}
	
	@Test
	public void userRoleShouldBeEmployee() {
		assertEquals("employee", testUser.getRole());
	}
	
	@Test 
	public void userUsernameShouldBejApple() {
		assertEquals("jApple", testUser.getUsername());
	}
}
