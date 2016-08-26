package com.wesdm.java8.lambda;

import java.util.Comparator;

public class Comparators {
	public static void main(String... args) {
		Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Alice", "Wonderland");

		System.out.println(comparator.compare(p1, p2));             // > 0
		System.out.println(comparator.reversed().compare(p1, p2));  // < 0
	}
}
class Person{
	String firstName;
	public Person(String first, String last){
		firstName = first;
	}
}
