package ee.bootcamp.codingwithdhaval;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NumberSpecs {

    @Test
    public void itSelectsPrimeNumbers() {
        //Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        //When
        List<Integer> primeNumbers = new Numbers(numbers).select(ThatAre.PRIME);

        //Then
        assertThat(primeNumbers, hasSize(2));
        assertThat(primeNumbers, hasItems(2, 3));
        assertThat(primeNumbers, not(hasItems(1, 4)));
    }

    @Test
    public void itDoesNotSelectNegativePrimeNumbers() {
        //Given
        List<Integer> numbers = Arrays.asList(-1, 2, -3, 4);

        //When
        List<Integer> primeNumbers = new Numbers(numbers).select(ThatAre.PRIME);

        //Then
        assertThat(primeNumbers, hasSize(1));
        assertThat(primeNumbers, hasItem(2));
        assertThat(primeNumbers, not(hasItems(-1, -3, 4)));
    }

    @Test
    public void itSelectsOddNumbers() {
        //Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        //When
        List<Integer> oddNumbers = new Numbers(numbers).select(ThatAre.ODD);

        //Then
        assertThat(oddNumbers, hasSize(2));
        assertThat(oddNumbers, hasItems(1, 3));
        assertThat(oddNumbers, not(hasItems(2, 4)));
    }

    @Test
    public void itDoesNotSelectNegativeOddNumbers() {
        //Given
        List<Integer> numbers = Arrays.asList(-1, 2, -3, 5);

        //When
        List<Integer> oddNumbers = new Numbers(numbers).select(ThatAre.ODD);

        //Then
       // assertThat(oddNumbers, hasSize(1));
        assertThat(oddNumbers, hasItems(5));
        assertThat(oddNumbers, not(hasItems(-1, -3, 2)));
    }


    @Test
    public void itSelectsOddPrimeNumbers() {
        //Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        //When
        List<Integer> oddNumbers = new Numbers(numbers).select(ThatAre.ODD, ThatAre.PRIME);

        //Then
        assertThat(oddNumbers, hasSize(1));
        assertThat(oddNumbers, hasItems(3));
        assertThat(oddNumbers, not(hasItems(1, 2, 4)));
    }

    @Test
    public void itSumsNumbers() {
        //Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        //When
        int sumOfNumbers = new Numbers(numbers).sum();

        //Then
        assertEquals(sumOfNumbers, 10);
    }

    @Test
    public void itSelectsNumbersInRange() {
        //Given
        List<Integer> numbers = Arrays.asList(5, 7, 10, 15);

        //When
        List<Integer> numbersInRange = new Numbers(numbers).selectInRange(5, 10);

        //Then
        Assert.assertThat(numbersInRange, hasSize(3));
        assertThat(numbersInRange, hasItems(5, 7, 10));
    }

    @Test
    public void itSumsOddPrimNumbersInRange() {
        //Given
        List<Integer> numbers = Arrays.asList(5, 7, 10, 15);

        //When
        int sumOfRangedOddPrimes = new Numbers(numbers)
                                    .select(ThatAre.PRIME, ThatAre.ODD)
                                    .selectInRange(5, 10)
                                    .sum();

        //Then
        assertEquals(sumOfRangedOddPrimes, 12);
    }

}
