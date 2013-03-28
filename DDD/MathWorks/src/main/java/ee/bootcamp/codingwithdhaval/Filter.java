package ee.bootcamp.codingwithdhaval;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    public List<Integer> select(List<Integer> numbers, ThatAre... conditions) {
        List<Integer> selectedNumbers = new ArrayList<Integer>();
        for (Integer number : numbers) {
            selectedNumbers.add(number);
            for (ThatAre condition : conditions) {
                if (!condition.isSatisfiedBy(number)) {
                    selectedNumbers.remove(number);
                }
            }
        }
        return selectedNumbers;
    }

    public List<Integer> selectInRange(List<Integer> numbers, int from, int to) {
        List<Integer> selectedNumbers = new ArrayList<Integer>();
        for(Integer number: numbers){
            if(number>=from && number<=to)
                selectedNumbers.add(number);
        }
        return selectedNumbers;
    }
}