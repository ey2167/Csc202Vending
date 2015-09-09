package vending;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;

public class Outputvending {
	static Scanner keyboard = new Scanner(System.in);
String filenamevending1 = "Vending1.txt";
String filenamevending2 = "Vending2.txt";
PrintWriter outputvending1 = null;
PrintWriter outputvending2 = null;

public String obtainDate(){
	Calendar calendar = null;
	 String currentDate = "";
	calendar = Calendar.getInstance();
	currentDate = calendar.get(Calendar.DATE) + "" + (calendar.get(Calendar.MONTH) + 1) + "" + calendar.get(Calendar.YEAR);
	return currentDate;
}
public String obtainfilename1(){
	String filename = obtainDate() + filenamevending1;
	return filename;
}
public String obtainfilename2(){
	String filename = obtainDate() + filenamevending2;
	return filename;
}

public void SaveSales1(Dispenser vending){
	try {
		outputvending1 = new PrintWriter(new FileOutputStream(obtainfilename1(),true));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("no file found");
		e.printStackTrace();
	}
	outputvending1.println("the current date is: " + obtainDate());
	System.out.println();
	for(int i = 0; i<10; i++){
		outputvending1.println("Sales of item '" + vending.dispenser1[i].foodname + "' "+ vending.dispenser1[i].foodprice * (20 -vending.dispenser1[i].foodamount));
		outputvending1.println();
	}
	outputvending1.close();
}

public void SaveSales2(Dispenser vending){
	try {
		outputvending2 = new PrintWriter(new FileOutputStream(obtainfilename2(),true));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	outputvending2.println("the current date is: " + obtainDate());
	System.out.println();
	for(int i = 0; i<10; i++){
		outputvending2.println("Sales of item '" + vending.dispenser2[i].foodname + "' " + vending.dispenser2[i].foodprice * (20 -vending.dispenser2[i].foodamount));
		outputvending2.println();
	}
	outputvending2.close();
}
}
