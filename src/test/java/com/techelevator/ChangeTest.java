package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ChangeTest {
	Change sut;

	@Before
	public void setUp() throws Exception {
		sut=new Change();
	}


	@Test
	public void testCalculateChangeInCents() {
		String s=sut.getChange(new BigDecimal("1.12"));
		assertEquals("Change: 4 Quarters 1 Dime 2 Pennies", s);
	}
	
	
	@Test
	public void testCalculateChangeInCentsNoChange() {
		String s=sut.getChange(new BigDecimal("0"));
		assertEquals("No change to return", s);

	}
	

}
