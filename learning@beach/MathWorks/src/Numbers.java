import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Shantanu
 * Date: 7/14/12
 * Time: 11:13 PM
 */
public class Numbers {

    ArrayList <Integer> numberList = new ArrayList <Integer> ();

    public Numbers (int[] inputNumbers) {

        for (int number : inputNumbers) {

            numberList.add (number);
        }
    }

    public Numbers getPrimes() {

        numberList = new PrimeNumberFilter ().filterThese (numberList);

        return this;
    }

    public Numbers getOdds() {

        numberList = new OddNumberFilter ().filterThese (numberList);

        return this;
    }

    public Numbers getRanged(int floor, int ceiling) {

        numberList = new RangedNumberFilter (floor, ceiling).filterThese (numberList);

        return this;

    }

    public Integer[] toIntegerArray () {

        return numberList.toArray (new Integer[0]);
    }
}
