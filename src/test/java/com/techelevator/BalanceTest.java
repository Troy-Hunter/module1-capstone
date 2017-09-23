package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class BalanceTest {
	Balance sut;
	@Before
	public void setUp() throws Exception {
		sut=new Balance();
	}
	
	@Test
	public void testAddToBalanceNegative() {
		sut.addToBalance(new BigDecimal("-1"));
		assertEquals(BigDecimal.ZERO, sut.getBalance());
	}

	@Test
	public void testAddToBalanceNothing() {
		sut.addToBalance(BigDecimal.ZERO);
		assertEquals(BigDecimal.ZERO, sut.getBalance());
	}
	
	@Test
	public void testAddToBalanceDecimalValue() {
		sut.addToBalance(new BigDecimal("1.4"));
		assertEquals(new BigDecimal("1.4"), sut.getBalance());
	}
	
	@Test
	public void testAddToBalanceNonDecimalValue() {
		sut.addToBalance(BigDecimal.ONE);
		assertEquals(BigDecimal.ONE, sut.getBalance());
	}
	
	@Test
	public void testTakeFromBalanceWhenYourBalanceIsLowerThanWithdrawlAmount() {
		sut.takeFromBalance(BigDecimal.ONE);
		assertEquals(BigDecimal.ZERO, sut.getBalance());
	}
	
	@Test
	public void testTakeFromBalanceNothing() {
		sut.takeFromBalance(BigDecimal.ZERO);
		assertEquals(BigDecimal.ZERO, sut.getBalance());
	}
	
	@Test
	public void testTakeFromBalanceNonDecimalAmount() {
		sut.addToBalance(BigDecimal.TEN);
		sut.takeFromBalance(BigDecimal.ONE);
		assertEquals(new BigDecimal("9"), sut.getBalance());
	}
	
	@Test
	public void testTakeFromBalanceDecimalAmount() {
		sut.addToBalance(BigDecimal.TEN);
		sut.takeFromBalance(new BigDecimal("1.2"));
		assertEquals(new BigDecimal("8.8"), sut.getBalance());
	}


}
