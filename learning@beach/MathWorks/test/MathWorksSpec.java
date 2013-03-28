import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Shantanu
 * Date: 7/14/12
 * Time: 5:08 PM
 */

public class MathWorksSpec {

    //given
    Numbers inputNumbers = new Numbers (new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
    Numbers outputNumbers;

    //Testing Story 1
    @Test
    public void itTestsPrimeNumbers () {

        //when
        outputNumbers = inputNumbers.getPrimes();

        //then
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 5, 7}, outputNumbers.toIntegerArray ());
    }

    //Testing Story 2
    @Test
    public void itTestsOddNumbers () {

        //when
        outputNumbers = inputNumbers.getOdds ();

        //then
        Assert.assertArrayEquals(new Integer[]{1, 3, 5, 7, 9}, outputNumbers.toIntegerArray ());
    }

    //Testing Story 3
    @Test
    public void itTestsOddPrimeNumbers () {

        //when
        outputNumbers = inputNumbers.getOdds ().getPrimes();

        //then
        Assert.assertArrayEquals(new Integer[]{1, 3, 5, 7}, outputNumbers.toIntegerArray ());
    }

    //Testing Story 4
    @Test
    public void itTestsRangedNumbers () {

        //when
        outputNumbers = inputNumbers.getRanged (5, 10);

        //then
        Assert.assertArrayEquals(new Integer[]{5, 6, 7, 8, 9}, outputNumbers.toIntegerArray ());
    }

    //Testing Story 5
    @Test
    public void itTestsRangedOddPrimeNumbers () {

        //when
        outputNumbers = inputNumbers.getRanged (5, 10).getOdds ().getPrimes ();

        //then
        Assert.assertArrayEquals(new Integer[]{5, 7}, outputNumbers.toIntegerArray ());
    }
}

