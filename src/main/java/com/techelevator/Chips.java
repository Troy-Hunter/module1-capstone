package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Product {
	private String sound="Crunch Crunch, Yum!";
	
	public Chips(String name, BigDecimal price){
		super(name, price);
	}
	
	@Override
	public String getSound() {
		// TODO Auto-generated method stub
		return sound;
	}

}
