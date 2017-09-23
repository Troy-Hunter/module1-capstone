package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class MoneyFormatTest {
	MoneyFormat sut;
	@Before
	public void setUp() throws Exception {
		sut=new MoneyFormat();
	}

	@Test
	public void testGetMoneyAmountInCorrectFormat1Dollar() {
		assertEquals("$1.00", MoneyFormat.getMoneyAmountInCorrectFormat(new BigDecimal("1")));

	}
	
	@Test
	public void testGetMoneyAmountInCorrectFormat1Dollar1Scale() {
		assertEquals("$1.00", MoneyFormat.getMoneyAmountInCorrectFormat(new BigDecimal("1.0")));

	}
	
	@Test
	public void testGetMoneyAmountInCorrectFormat1Dollar2Scale() {
		assertEquals("$1.00", MoneyFormat.getMoneyAmountInCorrectFormat(new BigDecimal("1.00")));

	}
	
	@Test
	public void testGetMoneyAmountInCorrectFormat1Dollar3Scale() {
		assertEquals("$1.00", MoneyFormat.getMoneyAmountInCorrectFormat(new BigDecimal("1.000")));

	}
	
	@Test
	public void testGetMoneyAmountInCorrectFormat10Dollars() {
		assertEquals("$10.00", MoneyFormat.getMoneyAmountInCorrectFormat(new BigDecimal("10")));

	}
	
	@Test
	public void testGetMoneyAmountInCorrectFormatNonWholeNumberDollars1Scale() {
		assertEquals("$1.10", MoneyFormat.getMoneyAmountInCorrectFormat(new BigDecimal("1.1")));

	}
	
	@Test
	public void testGetMoneyAmountInCorrectFormatNonWholeNumberDollars2Scale() {
		assertEquals("$1.12", MoneyFormat.getMoneyAmountInCorrectFormat(new BigDecimal("1.12")));

	}
	

}
