package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;


public class ProductTest {
	
	private Product sutChips;
	private Product sutCandy;
	private Product sutDrink;
	private Product sutGum;

	@Before
	public void setUp() throws Exception {
		
		sutChips = new Chips( "potato chips", new BigDecimal ("1"));
		sutCandy = new Candy( "skittles", new BigDecimal ("2"));
		sutDrink = new Drink( "water", new BigDecimal ("3"));
		sutGum = new Gum( "wintergreen", new BigDecimal ("5"));
		
	}

	@Test
	public void testChips() {
		assertEquals(new BigDecimal("1"), sutChips.getPrice());
		assertEquals("potato chips", sutChips.getName());
		assertEquals("Crunch Crunch, Yum!", sutChips.getSound());
	}
	
	@Test
	public void testCandy() {
		assertEquals(new BigDecimal("2"), sutCandy.getPrice());
		assertEquals("skittles", sutCandy.getName());
		assertEquals("Munch Munch, Yum!", sutCandy.getSound());
	}
	@Test
	public void testDrink() {
		assertEquals(new BigDecimal("3"), sutDrink.getPrice());
		assertEquals("water", sutDrink.getName());
		assertEquals("Glug Glug, Yum!", sutDrink.getSound());
	}
	@Test
	public void testGum() {
		assertEquals(new BigDecimal("5"), sutGum.getPrice());
		assertEquals("wintergreen", sutGum.getName());
		assertEquals("Chew Chew, Yum!", sutGum.getSound());
	}

}
