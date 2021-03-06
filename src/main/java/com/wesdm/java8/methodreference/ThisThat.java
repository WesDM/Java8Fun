package com.wesdm.java8.methodreference;

import com.wesdm.java8.Java8Fun;

/**
 * Example of how to use method and constuctor references as implementation to function interface
 * 
 * You use lambda expressions to create anonymous methods. Sometimes, however, a lambda expression does nothing but call an existing method. In those
 * cases, it's often clearer to refer to the existing method by name. Method references enable you to do this; they are compact, easy-to-read lambda
 * expressions for methods that already have a name.
 * 
 * @author Wesley
 *
 */
public class ThisThat implements Java8Fun {

	private String foo;
	private String bar;

	public static void main(String... args) {
		// Constructor reference
		ThisThatFactory<ThisThat> thisThatFactory = ThisThat::new;
		Java8Fun d = thisThatFactory.create(null, null);

		d.haveFun();
		((ThisThat) d).haveMoreFun(d);
	}

	public ThisThat() {
	}

	public ThisThat(String foo, String bar) {
		this.foo = foo;
		this.bar = bar;
	}

	/**
	 * Instance method reference as implementation of abstract method
	 * 
	 * @param d
	 */
	public void haveMoreFun(Java8Fun d) {
		Converter<String, String> converter = ((ThisThat) d)::endsWith; // ((ThisThat)d)::endsWith equals lambda expression: (f) -> d.endsWith(f);
		String converted = ((ThisThat) d).convert2(converter, "Coolio");
		System.out.println(converted);
	}

	/**
	 * Static method reference as implementation of abstract method
	 * 
	 * @param d
	 */
	@Override
	public void haveFun() {
		Integer converted = convert(Integer::valueOf, "123"); // Integer::valueOf equals lambda expression: (f) -> Integer.valueOf(f);
		System.out.println(converted);
	}

	private Integer convert(Converter<String, Integer> converter, String from) {
		return converter.convert(from);
	}

	private String convert2(Converter<String, String> converter, String from) {
		return converter.convert(from);
	}

	private String endsWith(String s) {
		return String.valueOf(s.charAt(s.length() - 1));
	}
}
