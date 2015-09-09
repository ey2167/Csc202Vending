package vending;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Vending extends Dispenser{
	private static Scanner keyboard = new Scanner(System.in);
	protected double chance;
	protected double timechance;
	protected double vendingcash=0;
	protected double total;
	public Dispenser Vending1;
	public Dispenser Vending2;
	Outputvending outputvending = new Outputvending();
	/**
	 * rolls two chances
	 */
	public void rollVendingChance(){
		chance = Math.random()*100;
		timechance = Math.random()*120;
	}
	/**
	 * to display the correct format of money
	 */
	public static String FormatMoney(double formatmoney){
		String money = "";
		DecimalFormat dollar = new DecimalFormat("$#,###,###.##");
		money = dollar.format(formatmoney);
		return money;
	}
	/**
	 * decides when to turn off machine after each purchase 
	 */
	public void RollVending1(){
		rollVendingChance();
		if(chance>=50){
			System.out.println("Machines will now turn off");
			outputvending.SaveSales1(Vending1);
			System.exit(0);
		}
	}
	public void RollVending2(){
		rollVendingChance();
		if(chance>=50){
			System.out.println("Machines will now turn off");
			outputvending.SaveSales1(Vending2);
			System.exit(0);
		}
	}
	
	/**
	 * determines when the customer arrives by using a generated chance from rollvendingchance
	 */
	public void Arrival(){
		rollVendingChance();
		for(int i = 5;i<120;i+=5){
		if((i-5)<= timechance && timechance < i){
			System.out.println("A Customer (That's you) Arrives at " + ((int)timechance/5) +":00 hours" );
			System.out.println();
		}
		}
	}
	/**
	 * rolls a chance to see which vending is used
	 * prepares the vending that is chosen and displays it to the Client
	 */
	public void whichVending(){
		System.out.println("You Flip a coin to decide which Vending Machine to use");
		rollVendingChance();
		if(chance>=50){
			Vending1 = new Dispenser();
			System.out.println("you have decided to use the 1st Vending Machine");
			System.out.println("the options are what you see below");
			fillVendor1();
			displayvender1();
			enterCash();
			purchase1();
			
		}
		else
		{
			Vending2 = new Dispenser();
			System.out.println("you have decided to use the 2nd Vending Machine");
		    System.out.println("the options are what you see below");
		    fillVendor2();
		    displayvender2();
		    enterCash();
		    purchase2();
		    }
	}
	/**
	 * this method will prompt the user to input cash into the vending machine
	 */
	public void enterCash(){
		boolean status = false;
		while(status == false){
		try{
		System.out.println("Please Enter Your how much money you would like to put in.");
		Double input = keyboard.nextDouble();
		keyboard.nextLine();
		vendingcash += input;
		status = true;
		}
		catch(InputMismatchException e){
			
		System.out.println("that's not money...please put in money.");
		System.out.println();
		keyboard.nextLine();
		}
		}
	}
	/**
	 * prompt the user to type the name of the item they wish to purchase
	 * if the amount of the item is zero, or if they do not have enough money, they will be told so and asked if they wish to continue
	 */
	public void purchase1(){
		boolean status = false;
		while(status == false){
		System.out.println("Type the name of the item you would like to purchase");
		System.out.println("Money Currently in Vending Machine: " + FormatMoney(vendingcash));
		System.out.println();
		try{
			boolean spellingcheck = false;
		String input = keyboard.next();
		keyboard.nextLine();
		for(int i = 0; i<10; i++)
		{
			if(Vending1.dispenser1[i].foodname.equals(input))
			{
				spellingcheck = true;
				if(Vending1.dispenser1[i].foodprice > this.vendingcash)
				{
					System.out.println("was money exception thrown?");
					throw new Exception("not enough money");
				}
				else if(Vending1.dispenser1[i].foodamount == 0)
				{
					System.out.println("was exception thrown in amount?");
					throw new Exception("SOLD OUT. CHOOSE SOMETHING ELSE");
					
				}
				else
				{
					this.vendingcash -= Vending1.dispenser1[i].foodprice;
					total += Vending1.dispenser1[i].foodprice;
					Vending1.dispenser1[i].foodamount--;
					displayreceipt(Vending1.dispenser1[i].foodname, Vending1.dispenser1[i].foodprice, vendingcash);
					Refund();
                    RollVending1();
				}
			}
		}
		if(spellingcheck == false){
			System.out.println("invalid input. remember to type the name of your purchase");
		}
		System.out.println("would you still wish to continue your purchase? click 'y' if so");
		String choice = keyboard.next();
		keyboard.nextLine();
		if(!(choice.equals("y"))){
			status = true;
		}
		else{
			
			enterCash();
			displayvender1();
		}
		}
		catch(Exception e){
			
			System.out.println(e.getMessage());
			
			System.out.println("would you still wish to continue your purchase? click 'y' if so");
			String input = keyboard.next();
			keyboard.nextLine();
			if(!(input.equals("y"))){
				status = true;
			}
			else{
				System.out.println("would you like to add more money into the vending machine? click 'y' if so");
				String obtain = keyboard.next();
				if((obtain.equals("y")))
				{
				enterCash();
				}
				displayvender1();
			}
			}
			}
		//put receipt here?
	}
	
	
	public void purchase2(){
		boolean status = false;
		while(status == false){
		System.out.println("Type the name of the item you would like to purchase");
		System.out.println("Money Currently in Vending Machine: " + FormatMoney(vendingcash));
		System.out.println();
		try{
			boolean spellingcheck = false;
		String input = keyboard.next();
		keyboard.nextLine();
		for(int i = 0; i<10; i++)
		{
			if(Vending2.dispenser2[i].foodname.equals(input))
			{
				spellingcheck = true;
				if(Vending2.dispenser2[i].foodprice > this.vendingcash)
				{
					System.out.println("was money exception thrown?");
					throw new Exception("not enough money");
				}
				else if(Vending2.dispenser2[i].foodamount == 0)
				{
					System.out.println("was exception thrown in amount?");
					throw new Exception("SOLD OUT. CHOOSE SOMETHING ELSE");
					
				}
				else
				{
					this.vendingcash -= Vending2.dispenser2[i].foodprice;
					total += Vending2.dispenser2[i].foodprice;
					Vending2.dispenser2[i].foodamount--;
					displayreceipt(Vending2.dispenser2[i].foodname, Vending2.dispenser2[i].foodprice, vendingcash);
					Refund();
					RollVending2();
				}
			}
		}
		if(spellingcheck == false){
			System.out.println("invalid input. remember to type the name of your purchase");
		}
		System.out.println("would you still wish to continue your purchase? click 'y' if so");
		String choice = keyboard.next();
		keyboard.nextLine();
		if(!(choice.equals("y"))){
			status = true;
			Refund();
		}
		else{
			enterCash();
			displayvender2();
		}
		}
		catch(Exception e){
			
			System.out.println(e.getMessage());
			
			System.out.println("would you still wish to continue your purchase? click 'y' if so");
			String input = keyboard.next();
			keyboard.nextLine();
			if(!(input.equals("y"))){
				status = true;
				Refund();
			}
			else{
				System.out.println("would you like to add more money into the vending machine? click 'y' if so");
				String obtain = keyboard.next();
				if((obtain.equals("y")))
				{
				enterCash();
				}
				displayvender2();
			}
			}
			}
		//put receipt here?
	}
	/*
	 * removes money from the vending machine
	 */
	public void Refund(){
		vendingcash = 0;
	}

/**
 * these methods will bascically setup the dispensers and the fooditems
 */
public void fillVendor1(){
	Vending1.createdispenser1();
	Vending1.setdispenser1();
}

public void fillVendor2(){
	Vending2.createdispenser2();
	Vending2.setdispenser2();
}

/**
 * these methods will allow the user to see the menu of the vendors
 */
public void displayvender1(){
		Vending1.displaydispenser1();
}
public void displayvender2(){
 Vending2.displaydispenser2();
}
/**
 * this method shall display the receipt with the total and subtotal of purchase
 */
public void displayreceipt(String foodname, double foodprice, double change){
	System.out.println("Here's your Receipt:");
	System.out.println("purchased item:" + foodname);
	System.out.println("price:" + FormatMoney(foodprice));
	System.out.println("Money Entered:" + FormatMoney(foodprice + change));
	System.out.println("Change:" + FormatMoney(change)); 
}
}
