package com.ee.mathworks.conditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class OddConditionSpec {
	@Test
	public void itDeterminesOddNumbers() {
		//Given
		Odd oddCondition = new Odd();

		//when
		boolean result = oddCondition.matches(1);
		//Then
		assertThat(result, is(true));
		
		//when
		result = oddCondition.matches(3);
		
		//Then
		assertThat(result, is(true));
	}
}
