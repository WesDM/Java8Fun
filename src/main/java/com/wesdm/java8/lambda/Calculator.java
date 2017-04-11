package com.wesdm.java8.lambda;

import com.wesdm.java8.Java8Fun;

/**
 * Example of how to implement default methods of a functional interface using
 * lambdas
 * 
 * @author Wesley
 *
 */
public class Calculator implements Java8Fun {

	public static void main(String... args) {
		Java8Fun d = new Calculator();
		d.haveFun();
	}


	public void haveFun() {
		lambdaExample();
		lambdaScopeExample();
	}
	
	/*
	 * Lambda example
	 */
	private void lambdaExample() {
		// Use lamba expression to provide implementation for single abstract
		// method
		// This ability to sign a function to a variable is what makes Java 8 functional
		Formula formula = (a) -> Math.sqrt(a * 100);

		System.out.println(formula.calculate(100)); // 100.0
		System.out.println(formula.sqrt(16)); // 4.0
		System.out.println(formula.round(2.5)); // 3.0
		
		// This ability to pass a function to a method is also what makes Java 8 functional
		double d = methodWithFunctionalInterfaceParam((a) -> Math.sqrt(a * 100), 100);
		System.out.println(d); // 100.0
	}
	
	/*
	 * Pass lambda expression as param when calling this method.
	 */
	private double methodWithFunctionalInterfaceParam(Formula ff, int a) {
		return ff.calculate(a);
	}
	
	
	/*
	 * Lambda scope example
	 */
	static int outerStaticNum;
    int outerNum;
    
	private void lambdaScopeExample() {
		int n = 100;
		Formula formula = (a) -> {
			//writing to n within lambda is prohibited
			//n = 3;
			
			//reading and writing from instance and static variables are allowed
			outerNum = 1;
			outerStaticNum = 3;
			
			return Math.sqrt(a * n);
		};
		//when used as a part of lambda, local variables must be implicitly final to compile
		//n = 1;
		
		//Cannot reference default method sqrt in lambda
		//formula = (a) -> sqrt(a * 100);
		
		//Can reference default method sqrt in lambda if referenced from previous instance
		Formula newformula = (a) -> formula.sqrt(a * 3);
		
		System.out.println(newformula.calculate(100)); 
		System.out.println(newformula.sqrt(16));
		System.out.println(newformula.round(2.5));
	}
}
