package com.autumn.zen.lambda.expression;

public class MethodReference {
	
	
	/** method reference type
	 * 
	 * object::instance method->object::toString;this::;super::
	 * class::static method->Math::pow
	 * class::instance method->String::compareToIgnoreCase
	 */
	
	static class Greeter{
		public void greet() {
			System.out.println("Hello World.");
		}
	}
	

	static class ConcurrentGreeter extends Greeter{
		
		@Override
		public void greet() {
			Thread t = new Thread(super::greet);
			t.start();
		}
		
	}
	
	
	
	
	
	

}
