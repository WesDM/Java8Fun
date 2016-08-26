package com.wesdm.java8.predicateexample;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonPredicates {
	
	public static Predicate<Person> isAdultMale() {
	    return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
	}
	
	public static Predicate<Person> isAdultFemale() {
	    return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
	}
	
	public static Predicate<Person> isAgeMoreThan(Integer age) {
	    return p -> p.getAge() > age;
	}
	
    public static List<Person> filterPersons (List<Person> employees, Predicate<Person> predicate) {
        return employees.stream().filter( predicate ).collect(Collectors.toList());
    }
}
