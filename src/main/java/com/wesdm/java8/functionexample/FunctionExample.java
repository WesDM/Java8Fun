package com.wesdm.java8.functionexample;

import static com.wesdm.java8.functionexample.IntegerFunctions.*;

import java.util.function.Function;
/**
 * Examples of functions
 * 
 * compose executes first
 * andThen executes last
 * @author Wesley
 *
 */
public class FunctionExample {
	public static void main(String args[]) {
		Integer i = times2.apply(2);
		System.out.println(i);
		
		String str = times2String.apply(2);
		System.out.println(str);
		
		//compose executes times2, then squared is executed
		i = squared.compose(times2).apply(3);
		System.out.println(i);
		
		//compose executes times2, then the first time2 is executed, and then executes squared
		i = times2.compose(times2).andThen(squared).apply(3);
		System.out.println(i);
		
		Function<Integer,Integer> time2squared = squared.compose(times2);
		i = time2squared.andThen(squared).compose(times2).andThen(times2).apply(2);
		System.out.println(i);
		
		i = divByZeroWrapped.apply(2);
		System.out.println(i);
	}
}
