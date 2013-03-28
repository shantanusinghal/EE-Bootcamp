package com.ee.mathworks.conditions;

public class WithinRange implements Condition {

	private final Integer upperBound;
	private final Integer lowerBound;

	public WithinRange(Integer lowerBound, Integer upperBound) {
		this.upperBound = upperBound;
		this.lowerBound = lowerBound;
	}

	@Override
	public boolean matches(Integer number) {
		return (number > lowerBound && number < upperBound);
	}

}
