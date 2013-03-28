package ee.bootcamp.dd;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class TestSpec {

    @Test
    public void itDoesSomething() {
        //Given
        Money inrTen = Money.valueOf("INR", 10);
        Money inrFive = Money.valueOf("INR", 5);
        Money anotherInrFive = Money.valueOf("INR", 5);
        //When
        //Then
        assertTrue(inrFive == anotherInrFive);
        assertFalse(inrFive == inrTen);
    }

}
