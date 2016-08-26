package com.wesdm.java8.predicateexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.wesdm.java8.predicateexample.PersonPredicates.*;

public class PredicateExample {

	public static void main(String... args) {
		Person e1 = new Person(1, 23, "M", "Rick", "Beethovan");
		Person e2 = new Person(2, 13, "F", "Martina", "Hengis");
		Person e3 = new Person(3, 43, "M", "Ricky", "Martin");
		Person e4 = new Person(4, 26, "M", "Jon", "Lowman");
		Person e5 = new Person(5, 19, "F", "Cristine", "Maria");
		Person e6 = new Person(6, 15, "M", "David", "Feezor");
		Person e7 = new Person(7, 68, "F", "Melissa", "Roy");
		Person e8 = new Person(8, 79, "M", "Alex", "Gussin");
		Person e9 = new Person(9, 15, "F", "Neetu", "Singh");
		Person e10 = new Person(10, 45, "M", "Naveen", "Jain");

		List<Person> Persons = new ArrayList<Person>();
		Persons.addAll(Arrays.asList(new Person[] { e1, e2, e3, e4, e5, e6, e7, e8, e9, e10 }));

		System.out.println(filterPersons(Persons, isAdultMale()));

		System.out.println(filterPersons(Persons, isAdultFemale()));

		System.out.println(filterPersons(Persons, isAgeMoreThan(35)));

		// Persons other than above collection of "isAgeMoreThan(35)" can be get
		// using negate() a.k.a less than 35
		System.out.println(filterPersons(Persons, isAgeMoreThan(35).negate()));
	}
}
