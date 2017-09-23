package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.techelevator.exceptions.PositionNotFoundException;
import com.techelevator.fileiostream.InputReaderForAVendingMachine;
import com.techelevator.fileiostream.LogWriter;

public class VendingMachine {
	public static final int STARTING_AMOUNT_OF_PRODUCT=5;
	
	private InputReaderForAVendingMachine inputItems; 
	private LogWriter logFile=new LogWriter();
	
	private Map<String, Product> vendingItems;
	private Map<Product, Integer> vendingItemsAmount;
	
	private Balance balance;
	private Change change;
	
	public VendingMachine(){
		inputItems=new InputReaderForAVendingMachine("/Users/ishaandixit/workspace/team5-java-module1-capstone/vendingmachine.csv", STARTING_AMOUNT_OF_PRODUCT);
		vendingItems=inputItems.getProducts();
		vendingItemsAmount=inputItems.getAmountOfEachProduct();
		this.balance=new Balance();
	}
	
	public VendingMachine(String userPath){
		inputItems=new InputReaderForAVendingMachine(userPath, STARTING_AMOUNT_OF_PRODUCT);
		vendingItems=inputItems.getProducts();
		vendingItemsAmount=inputItems.getAmountOfEachProduct();
		this.balance=new Balance();
		
	}
	
	public LogWriter getVendingLog(){
		return logFile;
	}
	public Map<String, Product> getVendingItems(){
		return vendingItems;
	}
	
	public String displayItems(){
		String s="";
		List<String> orderedKeySetVedningItems=new ArrayList<>(vendingItems.keySet());
		Collections.sort(orderedKeySetVedningItems);
		for(String position: orderedKeySetVedningItems){
			Product item=vendingItems.get(position);
			
			String amount=String.valueOf(vendingItemsAmount.get(item));
			if(isSoldOut(position)){
				amount="SOLD OUT";
			}
			s+="Position: "+ position+" Name: "+String.format("%-20s",item.getName())+ String.format("%30s"," Price: $")+item.getPrice() +" Quantity Remaining: " + amount +"\n";
		}
		return s;
	}
	
	public String feedMoney(BigDecimal dollarsAdded){
		String previousAmount=MoneyFormat.getMoneyAmountInCorrectFormat(balance.getBalance());
		balance.addToBalance(dollarsAdded);
		String updatedAmount=MoneyFormat.getMoneyAmountInCorrectFormat(balance.getBalance());
		logFile.writeToLog(logFile.makeFeedMoneyLine(previousAmount, updatedAmount));
		return "Current Money Provided: "+updatedAmount;
	}
	
	public Product selectProduct(String position){
		BigDecimal previousAmount=balance.getBalance();
		try{
			if(!vendingItems.containsKey(position)){
				throw new PositionNotFoundException();
			}
		} catch(PositionNotFoundException ex){
			return null;
		}
		if(this.isSoldOut(position)){
			return null;
		}
		
		Product item=vendingItems.get(position);
		boolean success=balance.takeFromBalance(item.getPrice());
		if(success){
			vendingItemsAmount.put(item, vendingItemsAmount.get(item)-1);
			logFile.writeToLog(logFile.makePurchaseMoneyLine(item.getName(), position, MoneyFormat.getMoneyAmountInCorrectFormat(previousAmount), MoneyFormat.getMoneyAmountInCorrectFormat(balance.getBalance())));
			return item;
		}else{
			return null;
		}
	}
	
	public String finishTransaction(){
		BigDecimal currentBalance=balance.getBalance();
		
		change=new Change();
		change.getChange(currentBalance);
	
		balance.takeFromBalance(currentBalance);
		logFile.writeToLog(logFile.makeChangeLine(MoneyFormat.getMoneyAmountInCorrectFormat(currentBalance), MoneyFormat.getMoneyAmountInCorrectFormat(balance.getBalance())));
		logFile.writeNewLineToLog();
		return change.toString();
	}
	
	public boolean isSoldOut(String position){
		return vendingItemsAmount.get(vendingItems.get(position))==0;
	}
	
}
