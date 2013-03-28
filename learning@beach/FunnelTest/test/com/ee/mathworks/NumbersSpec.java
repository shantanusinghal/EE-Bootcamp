package com.ee.mathworks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

import java.util.List;

import org.junit.Test;

import com.ee.mathworks.Numbers.Type;

public class NumbersSpec {

	@Test
	public void itSelectsOddNumbers() {
		// given
		Numbers numbers = new Numbers(1, 2, 3, 4, 5, 6);

		// when
		List<Integer> odd = numbers.select(Type.ODD);

		// THEN
		assertThat(odd, hasItems(1, 3, 5));
	}

	@Test
	public void itSelectsPrimeNumbers() {
		// Given
		Numbers numbers = new Numbers(1, 2, 3, 4, 5, 6);
		// when
		List<Integer> prime = numbers.select(Type.PRIME);
		// THEN
		assertThat(prime, hasItems(1, 2, 3, 5));
	}

	@Test
	public void itSelectsOddPrime() {
		// Given
		Numbers numbers = new Numbers(1, 2, 3, 4, 5, 6);

		// when
		Numbers oddPrimes = numbers.select(Type.PRIME).select(Type.ODD);
		// THEN
		assertThat(oddPrimes, hasItems(1, 3, 5));
	}

	@Test
	public void itSelectsMultipleOfFive() {
		Numbers numbers = new Numbers(1, 2, 3, 5, 10, 8, 25);
		// when
		List<Integer> multipleOfFive = numbers.select(Type.MULTIPLEOFFIVE);
		// THEN
		assertThat(multipleOfFive, hasItems(5, 10, 25));
	}

	@Test
	public void itSelectsOddMultipleOfFive() {
		Numbers numbers = new Numbers(1, 2, 3, 4, 5, 6, 10, 15, 25, 30);
		// when
		List<Integer> oddMultipleFive = numbers.select(Type.MULTIPLEOFFIVE)
				.select(Type.ODD);
		// THEN
		assertThat(oddMultipleFive, hasItems(5, 15, 25));
	}

	@Test
	public void itSelectsNumbersInARange() {
		Numbers numbers = new Numbers(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 25, 30);
		// when
		List<Integer> numbersInRange = numbers.withinRange(5, 10);
		// THEN
		assertThat(numbersInRange, hasItems(6, 7, 8, 9));
	}

	@Test
	public void itSelectsPrimeNumbersInARange() {
		// Given
		Numbers numbers = new Numbers(1, 2, 3, 4, 5, 6, 7, 11, 13, 17, 19, 21,
				23, 25, 27, 29, 31, 35, 40);
		// when
		List<Integer> prime = numbers.select(Type.PRIME).withinRange(2, 31);
		// THEN
		assertThat(prime, hasItems(3, 5, 7, 11, 13, 17, 19, 23, 29));
	}
}
