package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

import com.techelevator.view.Menu;
import com.techelevator.view.PurchasingProcessMenu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT="Exit Menu";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY="Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT= "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION="Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT,
																					PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
	
	
	
	
	private static final BigDecimal[] MAIN_MENU_POSSIBLE_MONEY_VALUES_TO_ADD={new BigDecimal("1.00"), new BigDecimal("2.00"), new BigDecimal("5.00"), new BigDecimal("10.00")};
	private Menu menu;
	private PurchasingProcessMenu purchaseProcessMenu;
	private VendingMachine vender;
	private Customer currentCustomer=new Customer();
	
	public VendingMachineCLI(Menu menu, PurchasingProcessMenu purchaseProcessMenu, VendingMachine vender) {
		this.menu = menu;
		this.purchaseProcessMenu=purchaseProcessMenu;
		this.vender=vender;
	}
	
	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}
	
	public void run() {
		while(true) {
			setCurrentCustomer(new Customer());
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				System.out.println(vender.displayItems());
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)){
				//do purchase
				vender.getVendingLog().writeNewCustomerIDToLog(Customer.getID());
				while(true){
					String choicePurchase = (String)purchaseProcessMenu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					if(choicePurchase.equals(PURCHASE_MENU_OPTION_FEED_MONEY)){
						BigDecimal moneyToFeed=purchaseProcessMenu.getMoneyToFeed("Please enter one of the following whole dollar amount [$1.00, $2.00, $5.00, $10.00]", MAIN_MENU_POSSIBLE_MONEY_VALUES_TO_ADD);
						if(moneyToFeed!=null){
							System.out.println(vender.feedMoney(moneyToFeed));
						}
					}
					else if(choicePurchase.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)){
						String position=purchaseProcessMenu.getPositionFromUser("Please Select A Product", vender);
						if(position!=null){
							Product item=vender.selectProduct(position);
							currentCustomer.addProduct(item);	
						}
					}
					else if(choicePurchase.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)){
						System.out.println(vender.finishTransaction());
						System.out.println(currentCustomer.leaveVendingMachineAndEatSnacks());
						break;
					}		
				} 
			}
			else if(choice.equals(MAIN_MENU_OPTION_EXIT)){
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		PurchasingProcessMenu purchaseProcessMenu=new PurchasingProcessMenu(System.in, System.out);
		VendingMachine vendy=new VendingMachine();
		VendingMachineCLI cli = new VendingMachineCLI(menu, purchaseProcessMenu, vendy);
		cli.run();
	}
}
