package com.ee.mathworks.conditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class MultipleOfFiveSpec {
	@Test
	public void itDeterminesMultipleOfFiveNumbers() {
		//Given
		MultipleOfFive multipleOfFiveCondition = new MultipleOfFive();

		//when
		boolean result = multipleOfFiveCondition.matches(5);
		//Then
		assertThat(result, is(true));
		
		//when
		result = multipleOfFiveCondition.matches(25);
		
		//Then
		assertThat(result, is(true));
	}
}
