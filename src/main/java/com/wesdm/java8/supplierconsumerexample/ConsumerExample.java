package com.wesdm.java8.supplierconsumerexample;

import java.util.List;
import java.util.function.Consumer;

import com.google.common.collect.Lists;

/**
 * Consumers represent a function that accepts a single argument of an arbitrary type and produce no result
 * 
 * @author Wesley
 *
 */
public class ConsumerExample {

	public static void main(String... args) {
		Consumer<User> userConsumer = (u) -> System.out.println("Username: " + u.getUsername());
		userConsumer.accept(new User("accept"));

		List<User> userList = Lists.newArrayList(new User("Phil"), new User("Will"));
		userList.stream().forEach(userConsumer);
	}
}
