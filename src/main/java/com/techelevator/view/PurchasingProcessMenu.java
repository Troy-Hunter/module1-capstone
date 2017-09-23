package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;

import com.techelevator.VendingMachine;
import com.techelevator.exceptions.PositionNotFoundException;

public class PurchasingProcessMenu extends Menu {
	
	public PurchasingProcessMenu(InputStream in, OutputStream out){
		super(in, out);
	}
	
	public BigDecimal getMoneyToFeed(String message, BigDecimal[] possibleMoneyOptionsToFeed) {
		BigDecimal moneyAmountToAddToBalance;
		
		moneyAmountToAddToBalance=super.getDecimalFromUser(message);
		
		boolean matches=false;
		for(BigDecimal moneyAmount: possibleMoneyOptionsToFeed){
			if(moneyAmountToAddToBalance.compareTo(moneyAmount)==0){
				matches=true;
			}
		}
		if(!matches) System.out.println("Money choice not found >>>");
		return (matches)? moneyAmountToAddToBalance: null;
	}
	
	public String getPositionFromUser(String message, VendingMachine vender){
		String inputtedPosition = null;
		super.getOut().println(message);
		super.getOut().flush();
		try {
			inputtedPosition = super.getIn().nextLine();
			
			if(!vender.getVendingItems().containsKey(inputtedPosition.toUpperCase())){
				inputtedPosition=null;
				throw new PositionNotFoundException();
			}
		} catch(PositionNotFoundException ex) {
			System.out.println("The product code was not found >>> ");
		}
		
		return inputtedPosition;
	}
}
