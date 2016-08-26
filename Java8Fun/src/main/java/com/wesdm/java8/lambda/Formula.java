package com.wesdm.java8.lambda;

@FunctionalInterface
public interface Formula {
	//Functional Interfaces have a single abstract method only
    double calculate(int a);
    
    //Java 8 allows us to put default method implementations as apart of interfaces
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
    
    default double round(double a){
    	return Math.round(a);
    }
    
	//trying to override Object method gives compile time error as
	//"A default method cannot override a method from java.lang.Object"
	
//	default String toString(){
//		return "i1";
//	}
}
