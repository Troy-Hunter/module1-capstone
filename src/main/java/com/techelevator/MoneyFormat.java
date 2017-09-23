package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class MoneyFormat {
	
	
	public static String getMoneyAmountInCorrectFormat(BigDecimal amount){
		amount=amount.setScale(2, RoundingMode.DOWN);
		return "$" + amount;
	}
	
	
	


}
