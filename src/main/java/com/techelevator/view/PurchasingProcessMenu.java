package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;

import com.techelevator.MoneyFormat;
import com.techelevator.VendingMachine;
import com.techelevator.exceptions.PositionNotFoundException;

public class PurchasingProcessMenu extends Menu {
	
	public PurchasingProcessMenu(InputStream in, OutputStream out){
		super(in, out);
	}
	
	public BigDecimal getMoneyToFeed(String message, BigDecimal[] possibleMoneyOptionsToFeed) {
		BigDecimal moneyAmountToAddToBalance=super.getDecimalFromUser(message);
		
		boolean matches=false;
		for(BigDecimal moneyAmount: possibleMoneyOptionsToFeed){
			if(MoneyFormat.getMoneyAmountInCorrectFormat(moneyAmountToAddToBalance).equals(MoneyFormat.getMoneyAmountInCorrectFormat(moneyAmount))){
				matches=true;
			}
		}
		if(!matches) System.out.println("Money choice not found >>>");
		return (matches)? moneyAmountToAddToBalance: null;
	}
	
	public String getPositionFromUser(String message, VendingMachine vender){
		String positionToGetItem = null;
		super.getOut().println(message);
		super.getOut().flush();
		try {
			String inputtedPosition = super.getIn().nextLine().toUpperCase();
			
			if(!vender.getVendingItems().containsKey(inputtedPosition)){
				throw new PositionNotFoundException();
			} else if(vender.isSoldOut(inputtedPosition)){
				System.out.println(vender.getVendingItems().get(inputtedPosition).getName()+ ": SOLD OUT");
			} else{
				positionToGetItem=inputtedPosition;
			}
		} catch(PositionNotFoundException ex) {
			System.out.println("The product code was not found >>> ");
		}
		
		return positionToGetItem;
	}
}
