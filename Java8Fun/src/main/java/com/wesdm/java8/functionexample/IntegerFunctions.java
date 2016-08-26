package com.wesdm.java8.functionexample;

import java.util.function.Function;

public class IntegerFunctions {
	//Function<I,R> I-type of input, R-type of result
	static Function<Integer, Integer> times2 = e -> e * 2;
	
	static Function<Integer, String> times2String = e -> String.valueOf(e * 2);

	static Function<Integer, Integer> squared = e -> e * e;
		
	static Function<Integer, Integer> divByZeroWrapped = e -> {
		try{
			return e / 0;
		}catch(Exception ex){
			ex.printStackTrace(System.out);
		}
		return null;
	};
}
