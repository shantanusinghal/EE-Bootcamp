import org.junit.Assert;
import org.junit.Test;

public class FilterSpec {

    //given
    Integer[] inputNumbers = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    Numbers number = new Numbers();

    //testing for Story 1
    @Test
    public void itTestsPrimes () {


        //when
        Numbers filteredList = number.applyOn(inputNumbers).applyFilter(Rule.ONLY_PRIMES);

        //then
        Assert.assertArrayEquals(new Integer[] {2, 3, 5, 7, 11, 13}, filteredList.getNumberList().toArray(new Integer [0]));
    }

    //testing for Story 2
    @Test
    public void itTestsOdds () {

        //when
        Numbers filteredList = number.applyOn (inputNumbers).applyFilter(Rule.ONLY_ODDS);

        //then
        Assert.assertArrayEquals(new Integer[] {1, 3, 5, 7, 9, 11, 13, 15}, filteredList.getNumberList().toArray(new Integer [0]));
    }

    //testing for Story 3
    @Test
    public void itTestsOddsAndPrimes () {

        //when
        Numbers filteredList = new Numbers().applyOn (inputNumbers).applyFilter(Rule.ONLY_ODDS).applyFilter(Rule.ONLY_PRIMES);

        //then
        Assert.assertArrayEquals(new Integer[] {3, 5, 7, 11, 13}, filteredList.getNumberList().toArray(new Integer [0]));
    }

    //testing for Story 4
    @Test
    public void itTestsRanges () {

        //when
        Numbers filteredList = new Numbers().applyOn (inputNumbers).applyFilter(Rule.WITHIN_RANGE.setRange (5,10));

        //then
        Assert.assertArrayEquals(new Integer[] {5, 6, 7, 8, 9, 10}, filteredList.getNumberList().toArray(new Integer [0]));
    }

    //testing for Story 5
    @Test
    public void itTestsRangesAndOddsAndPrimes () {

        inputNumbers = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35};

        //when
        Numbers filteredList = new Numbers().applyOn (inputNumbers).applyFilter(Rule.WITHIN_RANGE.setRange (2,31)).applyFilter(Rule.ONLY_ODDS).applyFilter(Rule.ONLY_PRIMES);

        //then
        Assert.assertArrayEquals(new Integer[] {3, 5, 7, 11, 13, 17, 19, 23, 29, 31}, filteredList.getNumberList().toArray(new Integer [0]));
    }
}
