package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Product {
	private String sound="Munch Munch, Yum!";
	
	public Candy(String name, BigDecimal price){
		super(name, price);
	}
	
	@Override
	public String getSound() {
		// TODO Auto-generated method stub
		
		return sound;
	}
	
}
