package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Product {
	private String sound="Chew Chew, Yum!";
	
	public Gum(String name, BigDecimal price){
		super(name, price);
	}
	
	@Override
	public String getSound() {
		// TODO Auto-generated method stub
		return sound;
	}
	


}
