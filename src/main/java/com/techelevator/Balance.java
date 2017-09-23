package com.techelevator;

import java.math.BigDecimal;

public class Balance {
	private BigDecimal balance;
	
	public Balance(){
		this.balance=new BigDecimal("0");
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void addToBalance(BigDecimal amount){
		try{
			if(amount.signum()==-1){
				throw new InvalidAmountAddedException();
			}
			this.balance=this.balance.add(amount);
		}catch(InvalidAmountAddedException ex){
			System.out.println("Sorry, you can't add a negative amount to balance");
		}
	}
	
	public boolean takeFromBalance(BigDecimal amount){
		try{
			if(this.getBalance().compareTo(amount)==-1){
				throw new BalanceTooLowException();
			}
			this.balance=this.balance.subtract(amount);
			return true;
		} catch(BalanceTooLowException ex){
			System.out.println("Sorry, you don't got the cash. Feed more.");
		}
		return false;
	}
	
}
