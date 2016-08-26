package com.wesdm.java8.methodreference;

@FunctionalInterface
public interface Converter<F,T> {
	T convert(F from);
}
