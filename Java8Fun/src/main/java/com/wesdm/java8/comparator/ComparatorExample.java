package com.wesdm.java8.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.wesdm.java8.predicateexample.Person;

public class ComparatorExample {
	
	public static void main(String[] args) {
		sortByFirstName();
		sortByFirstNameReversed();
		sortByFirstThenLastName();
		parallelSortByFirstThenLastName();
	}


	private static void parallelSortByFirstThenLastName() {
		List<Person> employees  = getEmployees();
		 
		//Sorting on multiple fields; Group by.
		Comparator<Person> groupByComparator = Comparator.comparing(Person::getFirstName)
		                                                    .thenComparing(Person::getLastName);
		//Parallel Sorting
		Person[] employeesArray = employees.toArray(new Person[employees.size()]);
		 
		//Parallel sorting
		Arrays.parallelSort(employeesArray, groupByComparator);
		 
		System.out.println(employeesArray);
	}


	private static void sortByFirstThenLastName() {
		List<Person> employees  = getEmployees();
		 
		//Sorting on multiple fields; Group by.
		Comparator<Person> groupByComparator = Comparator.comparing(Person::getFirstName)
		                                                    .thenComparing(Person::getLastName);
		employees.sort(groupByComparator);
		 
		System.out.println(employees);
	}


	private static void sortByFirstNameReversed() {
		List<Person> employees  = getEmployees();
	     
	    //Sort all employees by first name; And then reversed
	    Comparator<Person> comparator = Comparator.comparing(e -> e.getFirstName());
	    employees.sort(comparator.reversed());
	     
	    //Let's print the sorted list
	    System.out.println(employees);
	}


	private static void sortByFirstName() {
		List<Person> employees  = getEmployees();
	     
	    //Sort all employees by first name
	    employees.sort(Comparator.comparing(e -> e.getFirstName()));
	     
	    //OR you can use below
	    employees.sort(Comparator.comparing(Person::getFirstName));
	     
	    //Let's print the sorted list
	    System.out.println(employees);
	}
	
	
	private static List<Person> getEmployees(){
	    List<Person> employees  = new ArrayList<>();
	    employees.add(new Person(1,"Lokesh", "Gupta", 32));
	    employees.add(new Person(2,"Aman", "Sharma", 28));
	    employees.add(new Person(3,"Aakash", "Yaadav", 52));
	    employees.add(new Person(4,"James", "Hedge", 72));
	    employees.add(new Person(5,"David", "Kameron", 19));
	    employees.add(new Person(6,"Yash", "Chopra", 25));
	    employees.add(new Person(7,"Karan", "Johar", 59));
	    employees.add(new Person(8,"Balaji", "Subbu", 88));
	    employees.add(new Person(9,"Vishu", "Bissi", 33));
	    employees.add(new Person(10,"Lokesh", "Ramachandran", 60));
	    return employees;
	}
}
