package com.techelevator.fileiostream;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.Candy;
import com.techelevator.Chips;
import com.techelevator.Drink;
import com.techelevator.Gum;
import com.techelevator.Product;

public class InputReaderForAVendingMachine { 
	private Map<String, Product> products=new HashMap<String, Product>();
	private Map<Product, Integer> amountOfTheProduct=new HashMap<Product, Integer>();
	String filePath="/Users/ishaandixit/workspace/team5-java-module1-capstone/vendingmachine.csv";
	
	public InputReaderForAVendingMachine(int amount){
		readVendingInputIntoMap(amount);
	}
	
	public InputReaderForAVendingMachine(String filePath, int amount){
		this.filePath=filePath;
		readVendingInputIntoMap(amount);
	}
	
	public void readVendingInputIntoMap(int amount){
		
		File fileToBeRead=new File(filePath);
		
		try(Scanner input=new Scanner(fileToBeRead)){
			while(input.hasNextLine()){
				String line=input.nextLine();
				String[] parts=line.split("\\|");
				
				char type=parts[0].charAt(0);
				BigDecimal price=new BigDecimal(parts[2]);
				Product productToPutInMap;
				switch(type){
					case 'A': productToPutInMap=new Chips(parts[1], price);
							  break;
					case 'B': productToPutInMap=new Candy(parts[1], price);
							  break;
					case 'C': productToPutInMap=new Drink(parts[1], price);
							  break;
					case 'D': productToPutInMap=new Gum(parts[1], price);
							  break;
					default: productToPutInMap=null;
							 break;
				}
				
				if (productToPutInMap!=null){
					products.put(parts[0], productToPutInMap);
					amountOfTheProduct.put(productToPutInMap, amount);
				}
			}
		} catch(FileNotFoundException ex){
			ex.printStackTrace();
		}
	}

	public Map<String, Product> getProducts() {
		return products;
	}

	public Map<Product, Integer> getAmountOfEachProduct() {
		return amountOfTheProduct;
	}

	public String getFilePath() {
		return filePath;
	}
}
