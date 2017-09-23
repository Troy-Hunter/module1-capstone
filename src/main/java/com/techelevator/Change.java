package com.techelevator;

import java.math.BigDecimal;

public class Change {
	private int[] changeAmount=new int[4]; //index 0 is Quarters, 1 is Dimes, 2 is Nickels, and 3 are Pennies
	private BigDecimal[] changeValues={new BigDecimal(".25"), new BigDecimal(".10"), new BigDecimal(".05"), new BigDecimal(".01")};
	private String[] changeNames={"Quarter", "Dime", "Nickel", "Penny"};
	
	public String getChange(BigDecimal amount){
		calculateChangeInCents(amount);
		return this.toString();
	}
	
	private void calculateChangeInCents(BigDecimal amount){
		for(int i=0; i< changeValues.length; i++){
			changeAmount[i]=amount.divideToIntegralValue(changeValues[i]).intValue();
			amount=amount.remainder(changeValues[i]);
			if(amount.equals(BigDecimal.ZERO)){
				break;
			}
		}
	}
	
	public String toString(){
		String s="Change: ";
		int changeValuesThatAre0=0;
		for(int i=0; i<changeAmount.length; i++){
			if(changeAmount[i]!=0){
				String changeValueName=changeNames[i]; //for handeling the plural cases
	
				if(changeAmount[i]!=1){ //plural
					if(changeNames[i].equals("Penny")){
						changeValueName="Pennies";
					}
					else{
						changeValueName+="s";
					}
				}
				s+=changeAmount[i]+" " +changeValueName;
				if(i!=changeAmount.length-1){
					s+=" ";
				}
			}
			else{
				changeValuesThatAre0++;
				continue;
			}
			
			
		}
		if(changeValuesThatAre0==changeAmount.length) s="No change to return";
		return s;
	}

}
