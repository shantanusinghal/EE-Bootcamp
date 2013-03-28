package com.ee.mathworks.conditions;

 class Prime implements Condition {

	public boolean matches(Integer number) {
		return isPrime(number);
	}

	boolean isPrime(int number) {
		int modulus = 0;
		for (modulus = 2; modulus < number; modulus++) {
			if ((number % modulus) == 0)
				return false;
			}
		return true;
	}
}
