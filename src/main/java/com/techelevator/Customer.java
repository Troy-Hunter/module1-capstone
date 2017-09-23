package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private static int id=0;
	private List<Product> productsPurchased;
	
	public Customer(){
		productsPurchased=new ArrayList<Product>();
		id++;
	}
	
	public static int getID(){
		return id;
	}

	public List<Product> getProductsPurchased() {
		return productsPurchased;
	}
	
	
	public void addProduct(Product item){
		productsPurchased.add(item);
	}
	
	public String consumeItem(){
		Product productToBeConsumed=productsPurchased.remove(0);
		return productToBeConsumed.getSound();
	}
	
	public String leaveVendingMachineAndEatSnacks(){
		String s="";
		while(this.getProductsPurchased().size()!=0){
			s+=this.consumeItem();
			s+=(this.getProductsPurchased().size()==0)? "":"\n";
		}
		return s;
	}

}
