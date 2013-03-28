import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Shantanu
 * Date: 7/15/12
 * Time: 1:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class RangedNumberFilter {

    private int floor;
    private int ceiling;

    public RangedNumberFilter(int floor, int ceiling) {

        this.floor = floor;
        this.ceiling = ceiling;
    }

    public ArrayList <Integer> filterThese (ArrayList <Integer> inputNumbers) {

        //create a replica of the input list
        ArrayList <Integer> outputNumbers = new ArrayList <Integer> ();

        outputNumbers.addAll (inputNumbers);

        //loop over the entire list of input numbers
        for (Integer number : inputNumbers) {

            //if the rightmost bit is a zero then the number is odd
            if (number < floor || number > ceiling) {

                //remove the odd numbers from the replica list
                outputNumbers.remove (outputNumbers.indexOf (number));
            }
        }

        //return the trimmed replicated list as the output
        return outputNumbers;
    }
}
