package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Product {
	private String sound="Glug Glug, Yum!";
	
	public Drink(String name, BigDecimal price){
		super(name, price);
	}
	
	@Override
	public String getSound() {
		// TODO Auto-generated method stub
		return sound;
	}
}
