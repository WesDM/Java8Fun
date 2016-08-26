package com.wesdm.java8.repeatableannotations;

public class Diet {
	@Meal(value = "breakfast", mainDish="cereal")
	@Meal(value = "breakfast", mainDish="pizza")
	@Meal(value = "breakfast", mainDish="salad")
	public void evaluateDiet() {}
}
