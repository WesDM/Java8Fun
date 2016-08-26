package com.wesdm.java8.methodreference;

/**
 * Factory for creating ThisThat objects
 * @author Wesley
 *
 * @param <T>
 */
@FunctionalInterface
public interface ThisThatFactory<T extends ThisThat> {
	T create(String foo, String bar);
}
