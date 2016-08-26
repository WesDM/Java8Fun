package com.wesdm.java8.optional;

import java.util.Optional;

public class Optionals {
	 public static void main(String[] args) {
		 Optional<String> firstName = optTest(1);
		 System.out.println( "First Name is set? " + firstName.isPresent() );        
		 System.out.println( "First Name: " + firstName.orElseGet( () -> "[none]" ) ); 
		 System.out.println( firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
	}
	 
	 
	 private static Optional<String> optTest(int i){
		 String s = (i == 0 ?  "Tom" : null);
		 return Optional.ofNullable(s);
	 }
}
