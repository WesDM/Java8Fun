package com.wesdm.java8.supplierconsumerexample;

import java.util.function.Supplier;

/**
 * Suppliers represent a function that accepts no arguments and produce a result of some arbitrary type
 * @author Wesley
 *
 */
public class SupplierExample {
	
	public static void main(String... args) {
		//Supplier references a constructor
		Supplier<User> userSupplier = User::new;
		User user = userSupplier.get();
		
		//Supplier references a static method
		userSupplier = UserFactory::produceUser;
		user = userSupplier.get();
		
		//Supplier references a instance method
		Supplier<SupplierExample> exampleSupplier = SupplierExample::new;
		userSupplier = exampleSupplier.get()::produceUser;
		user = userSupplier.get();
	}
		
	private User produceUser(){
		  return new User();
		}
}

class User{
	String username;
	
	public User(){}
	
	public User(String username){
		this.username = username;
	}

	String getUsername(){
		return username;
	}
}

class UserFactory {
	  public static User produceUser() {
	    return new User();
	  }
}
