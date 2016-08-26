package com.wesdm.java8.repeatableannotations;

import java.lang.annotation.Repeatable;

@Repeatable(MealContainer.class)
public @interface Meal {
	String value();
	String mainDish();
	String date() default "[unknown]";
}
