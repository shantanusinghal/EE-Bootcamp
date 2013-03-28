import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Shantanu
 * Date: 7/14/12
 * Time: 6:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrimeNumberFilter {

    public ArrayList <Integer> filterThese (ArrayList <Integer> inputNumbers) {

        //create a replica of the input list
        ArrayList <Integer> outputNumbers = new ArrayList <Integer> ();

        outputNumbers.addAll (inputNumbers);

        //loop over the entire list of input numbers
        for (Integer number : inputNumbers) {

            for (Integer tester = 2; tester < number; tester++) {

                if (number % tester == 0) {

                    //remove the non-prime numbers from the replica list
                    outputNumbers.remove (outputNumbers.indexOf (number));

                    break;
                }
            }
        }

        //return the trimmed replicated list as the output
        return outputNumbers;
    }
}
