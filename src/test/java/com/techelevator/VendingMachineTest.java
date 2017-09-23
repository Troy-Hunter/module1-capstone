package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	VendingMachine sut;
	
	@Before
	public void setUp() throws Exception {
		sut=new VendingMachine();
	}

	@Test
	public void testisSoldOut() {
		assertEquals(false, sut.isSoldOut("A1"));
		sut.feedMoney(new BigDecimal("40"));
		sut.selectProduct("A1");
		sut.selectProduct("A1");
		sut.selectProduct("A1");
		sut.selectProduct("A1");
		sut.selectProduct("A1");
		assertEquals(true, sut.isSoldOut("A1"));
	}
	
	@Test
	public void testSelectProduct() {
		assertEquals(null, sut.selectProduct("New York"));
		sut.feedMoney(new BigDecimal("40"));
		sut.selectProduct("A1");
		sut.selectProduct("A1");
		sut.selectProduct("A1");
		sut.selectProduct("A1");
		sut.selectProduct("A1");
		assertEquals(null, sut.selectProduct("A1"));
		Product put=sut.selectProduct("A2");
		assertEquals(new Chips("Stackers", new BigDecimal("1.75")).getName(), put.getName());
		assertEquals(new Chips("Stackers", new BigDecimal("1.75")).getPrice(), put.getPrice());
	}
}
