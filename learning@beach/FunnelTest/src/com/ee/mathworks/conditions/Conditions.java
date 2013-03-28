package com.ee.mathworks.conditions;

import com.ee.mathworks.Numbers;

public class Conditions {
	public Condition create(String typeName, Integer ...args){
		if(Numbers.Type.PRIME.name().equalsIgnoreCase(typeName)) {
			return new Prime();
		}
		if(Numbers.Type.ODD.name().equalsIgnoreCase(typeName)) {
			return new Odd();
		}
		if(Numbers.Type.MULTIPLEOFFIVE.name().equalsIgnoreCase(typeName)) {
			return new MultipleOfFive();
		}
		if("WithinRange".equalsIgnoreCase(typeName)) {
			return new WithinRange(args[0], args[1]);
		}
		throw new UnsupportedOperationException();
	}

}
