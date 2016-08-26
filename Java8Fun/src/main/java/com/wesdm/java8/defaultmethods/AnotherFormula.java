package com.wesdm.java8.defaultmethods;

public interface AnotherFormula {
	
	//Abstract methods. Typical interface goodness.
    double calculate(int a);
    double abstactMeth();
    
    //Default methods. New Java 8 goodness. Gives abstract classes a run for it's money.
    default double sqrt(int a) {
        return Math.sqrt(a*abstactMeth()); 	//boom. we can call the impl of abstract method from default methods.
    }
    
    default double round(double a){
    	return Math.round(a);
    }


}
