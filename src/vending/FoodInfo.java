package vending;

public class FoodInfo {
	FoodInfo(){
	}
	
protected double foodprice;
protected String foodname;
protected String foodnutrition;
protected int foodamount = 20;
/**
 * obtain food information from parameters
 */
protected void obtainFoodInfo(double foodprice,String foodname, String foodnutrition,int foodamount){
	this.foodname = foodname;
	this.foodprice = foodprice;
	this.foodnutrition = foodnutrition;
	this.foodamount = foodamount;
}
/**
 * display the foodinformation
 */
protected void DisplayFoodInfo(){
	System.out.println("Product Name: " + this.foodname);
	System.out.println("Price: $" + this.foodprice);
	System.out.println("Nutrition Info: '" + this.foodnutrition + "'");
	System.out.println("You notice " + this.foodamount + " of the items inside the dispenser");
	System.out.println();

	
}
}
