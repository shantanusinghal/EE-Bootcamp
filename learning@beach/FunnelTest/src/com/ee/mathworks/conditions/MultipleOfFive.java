package com.ee.mathworks.conditions;

class MultipleOfFive implements Condition {

	@Override
	public boolean matches(Integer number)
	{
		return isMultipleOfFive(number);
	}
	boolean isMultipleOfFive(int number){
		if((number%5)==0)
			return true;		
		return false;
		}
}
