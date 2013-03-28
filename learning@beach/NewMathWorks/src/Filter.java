import java.util.ArrayList;

public class Filter {

    private Rule filterByRule = null;

    Filter () {

        return;
    }

    Filter (Rule newRule) {

        this.filterByRule = newRule;
    }

    public Filter with (Rule newRule) {

        return new Filter (newRule);
    }

    public ArrayList <Integer> getFilteredResultsFrom (ArrayList <Integer> inputNumbers) {

        ArrayList <Integer> outputNumbers = new ArrayList <Integer> ();

        for (Integer number : inputNumbers) {

            if (filterByRule.test (number) == true) {

                outputNumbers.add (number);
            }
        }

        return outputNumbers;
    }
}
