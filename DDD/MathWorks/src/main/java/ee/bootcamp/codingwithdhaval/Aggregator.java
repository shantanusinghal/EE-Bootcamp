package ee.bootcamp.codingwithdhaval;

import java.util.List;

public class Aggregator {

    public int sum(List<Integer> numbers) {
        int sumOfNumbers = 0;
        for(Integer number : numbers) {
            sumOfNumbers += number;
        }
        return sumOfNumbers;
    }
}
