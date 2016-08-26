package com.wesdm.java8.defaultmethods;

public class FormulaImpl implements Formula, AnotherFormula{

	@Override
	public double calculate(int a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double abstactMeth() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//Forced to override when colliding default method sigs are detected
	@Override
	public double sqrt(int a) {
		// TODO Auto-generated method stub
		return Formula.super.sqrt(a);
	}

	@Override
	public double round(double a) {
		// TODO Auto-generated method stub
		return Formula.super.round(a);
	}
	
}
