package explore.topics.hackerrank;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CalculateTheSquareTest {

    private CalculateTheSquare calculateTheSquare;

    @Before
    public void solution() {
        calculateTheSquare = new CalculateTheSquare();
    }

    @Test
    public void countRecursiveSquares() {
        assertEquals(calculateTheSquare.countRecursiveSquares(256), 3);
        assertEquals(calculateTheSquare.countRecursiveSquares(64), 1);
        assertEquals(calculateTheSquare.countRecursiveSquares(4), 1);
        assertEquals(calculateTheSquare.countRecursiveSquares(3), 0);
        assertEquals(calculateTheSquare.countRecursiveSquares(0), 0);
    }

    @Test
    public void isWholeNumber() {
        assertTrue(calculateTheSquare.isWholeNumber(4));
        assertFalse(calculateTheSquare.isWholeNumber(2));
        assertTrue(calculateTheSquare.isWholeNumber(64));
        assertTrue(calculateTheSquare.isWholeNumber(0));
    }
}
