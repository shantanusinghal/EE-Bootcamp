package com.ee.mathworks.conditions;

class Odd implements Condition {

	public boolean matches(Integer number) {
		return isOdd(number);
	}

	boolean isOdd(int number) {
		return ((number % 2) != 0);
	}
}
