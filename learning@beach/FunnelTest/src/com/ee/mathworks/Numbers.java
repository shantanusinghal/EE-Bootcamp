package com.ee.mathworks;

import java.util.ArrayList;

import com.ee.mathworks.conditions.Condition;
import com.ee.mathworks.conditions.Conditions;

public class Numbers extends ArrayList<Integer> {
	public enum Type {
		PRIME, MULTIPLEOFFIVE, ODD;
	}

	private Conditions conditionFactory = new Conditions();

	private Numbers() {}

	public Numbers(int... numbers) {
		for (Integer number : numbers) {
			this.add(number);
		}
	}

	public Numbers select(Type type) {
		Condition condition = conditionFactory.create(type.name());
		return select(condition);
	}
	
	private Numbers select(Condition condition) {
		Numbers selected = new Numbers();
		for (Integer aNumber : this) {
			if (condition.matches(aNumber))
				selected.add(aNumber);
		}
		return selected;
	}

	public Numbers withinRange(Integer lowerBound, Integer upperBound) {
		Condition condition = conditionFactory.create("WithinRange",lowerBound,upperBound);
		return select(condition);
	}
}
