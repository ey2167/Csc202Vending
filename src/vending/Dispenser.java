package vending;

public class Dispenser extends FoodInfo {
protected FoodInfo[] dispenser1 = new FoodInfo[10];
protected FoodInfo[] dispenser2 = new FoodInfo[10];
/**
 * creates the objects for the dispenser
 */
protected void createdispenser1(){
	for(int i = 0;i<10;i++){
		
		dispenser1[i]= new FoodInfo();
	}
}
protected void createdispenser2(){
	for(int i = 0;i<10;i++){
		
		dispenser2[i]= new FoodInfo();
	}
}
/**
 * show the food in the dispenser
 */
protected void displaydispenser1(){
	for(int i = 0; i<10;i++){
		dispenser1[i].DisplayFoodInfo();
	}
}

protected void displaydispenser2(){
	for(int i = 0; i<10;i++){
		dispenser2[i].DisplayFoodInfo();
	}
}
/**
 * set food inside the dispenser
 */
protected void setdispenser1(){
	
	dispenser1[0].obtainFoodInfo(1.20, "Apple","Eat a day to keep the doctors away" , 20);
	dispenser1[1].obtainFoodInfo(.75, "Banana","gotta love potassium" , 20);
	dispenser1[2].obtainFoodInfo(1.35, "Orange","the Fruit to prevent scurvy" , 20);
	dispenser1[3].obtainFoodInfo(1.75, "Milk","Calcium for Bones" , 20);
	dispenser1[4].obtainFoodInfo(1.00, "HoneyBar","natural sugar for some energy" , 20);
	dispenser1[5].obtainFoodInfo(1.40, "CheerioBar","the bar with 100% whole oats" , 20);
	dispenser1[6].obtainFoodInfo(1.35, "BlueBerryJuice","to help clear your head" , 20);
	dispenser1[7].obtainFoodInfo(1.00, "OatBar","filled with Fiber" , 20);
	dispenser1[8].obtainFoodInfo(1.50, "WaterBottle","vital for keeping your hydrated" , 20);
	dispenser1[9].obtainFoodInfo(1.45, "CarrotPack","a rich source of Vitamin A" , 20);
}
protected void setdispenser2(){
	dispenser2[0].obtainFoodInfo(1.10, "AppleJuice","Drink a day to keep the doctors away" , 20);
	dispenser2[1].obtainFoodInfo(1.00, "BananaBar","a potassium rich snack" , 20);
	dispenser2[2].obtainFoodInfo(1.35, "OrangeJuice","the Beverage to prevent scurvy" , 20);
	dispenser2[3].obtainFoodInfo(1.00, "MilkBar","a Bar Rich in Calcium" , 20);
	dispenser2[4].obtainFoodInfo(1.35, "HoneyNutCereal","Cereal with natural sugar for some energy" , 20);
	dispenser2[5].obtainFoodInfo(1.40, "CheerioCereal","cereal with 100% whole oats" , 20);
	dispenser2[6].obtainFoodInfo(1.00, "BlueBerryBar","the bar to help clear your head" , 20);
	dispenser2[7].obtainFoodInfo(1.00, "Fibernuts","Has Fiber in it" , 20);
	dispenser2[8].obtainFoodInfo(1.50, "Cola","for a burst of energy" , 20);
	dispenser2[9].obtainFoodInfo(1.35, "CarrotJuice","a juice with rich source of Vitamin A" , 20);
}

}
