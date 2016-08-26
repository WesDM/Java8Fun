package com.wesdm.java8.defaultmethods;

import com.wesdm.java8.Java8Fun;

/**
 * Example of how to implement default methods of a non functional interface
 * using anonymous classes
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
		anonymousClassExample();
	}

	private void anonymousClassExample() {
		// must use anon class when implementing NON functional interface
		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}

			@Override
			public double abstactMeth() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public double sqrt(int a){return 0;}
		};

		System.out.println(formula.calculate(100)); // 100.0
		System.out.println(formula.sqrt(16)); // 4.0
		System.out.println(formula.round(2.5)); // 3.0
	}
}
