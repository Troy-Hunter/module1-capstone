package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	private Customer sut;
	
	
	@Before
	public void setUp() throws Exception {
		sut = new Customer();
	}

	@Test
	public void testAddProduct() {
		sut.addProduct(new Chips("potato chips", new BigDecimal ("1")));
		assertEquals("potato chips", sut.getProductsPurchased().get(0).getName());
		
	}
	@Test
	public void testConsumeItem() {
		sut.addProduct(new Chips("potato chips", new BigDecimal ("1")));
		assertEquals("Crunch Crunch, Yum!", sut.consumeItem());
	}

}
