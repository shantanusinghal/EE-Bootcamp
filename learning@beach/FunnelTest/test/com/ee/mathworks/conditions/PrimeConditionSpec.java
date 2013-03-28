package com.ee.mathworks.conditions;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.Test;

public class PrimeConditionSpec {
	@Test
	public void itDeterminesPrimeNumbers() {
		//Given
		Prime primeCondition = new Prime();
		
		//when
		boolean result = primeCondition.matches(1);
		//Then
		assertThat(result, is(true));
		
		//when
		result = primeCondition.matches(2);
		
		//Then
		assertThat(result, is(true));
	}
}
