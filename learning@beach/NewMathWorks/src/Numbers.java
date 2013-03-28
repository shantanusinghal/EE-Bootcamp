import java.util.ArrayList;

public class Numbers {

    private ArrayList <Integer> numberList = new ArrayList <Integer> ();

    public Numbers() {

        return;
    }

    Numbers (Integer[] inputNumbers) {

        for (Integer number : inputNumbers) {

            numberList.add (number);
        }
    }

    public ArrayList <Integer> getNumberList () {

        return numberList;
    }

    public Numbers applyOn(Integer[] inputNumbers) {

        return new Numbers (inputNumbers);
    }

    public Numbers applyFilter (Rule aRule) {

        numberList = new Filter().with (aRule).getFilteredResultsFrom (numberList);

        return this;
    }
}
