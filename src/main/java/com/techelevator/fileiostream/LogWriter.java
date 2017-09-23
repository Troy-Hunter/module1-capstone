package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogWriter {
	String pathToLog="/Users/ishaandixit/workspace/team5-java-module1-capstone/log.txt";
	File log;
	SimpleDateFormat formatDate=new SimpleDateFormat("dd/MM/yyyy hh:mm aaa");
	PrintWriter appendingFile;
	String currentDateTime;
	
	public LogWriter(){
		log=new File(pathToLog);
		try {
			appendingFile=new PrintWriter(new FileOutputStream(log), true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public LogWriter(String pathToLog){
		this.pathToLog=pathToLog;
		log=new File(pathToLog);
		try {
			appendingFile=new PrintWriter(new FileOutputStream(log), true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String makeFeedMoneyLine(String previousAmount, String updatedAmount){
		currentDateTime=formatDate.format(new Date());
		String output=String.format("%-20s", " FEED Money:  ") + String.format("%-12s", previousAmount)+ " "+ updatedAmount;
		return currentDateTime+ output;
	}
	
	public String makePurchaseMoneyLine(String purchase, String position, String previousAmount, String updatedAmount){
		currentDateTime=formatDate.format(new Date());
		String output=String.format("%-20s", " "+  purchase + " " +position+"  ") + String.format("%-12s", previousAmount)+ " " +updatedAmount;
		return currentDateTime+ output;
	}
	
	public String makeChangeLine(String previousAmount, String updatedAmount){
		currentDateTime=formatDate.format(new Date());
		String output=String.format("%-20s", " GIVE CHANGE:  ") + String.format("%-12s", previousAmount)+ " " +updatedAmount;
		return currentDateTime+ output;
	}
	
	public void writeToLog(String line){	
		appendingFile.println(line);
		
	}
	
	public void writeNewLineToLog(){	
		appendingFile.println("\n");
		
	}
	
	public void writeNewCustomerIDToLog(int id){	
		String r=(int)(Math.random()*Math.pow(10, 5))+""+id;
		appendingFile.println("Customer ID: RN"+r);
		
	}
}
