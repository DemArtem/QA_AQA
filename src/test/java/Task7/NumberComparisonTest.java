package Task7;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class NumberComparisonTest {
    @Test
    public void testCompareNumbers_Greater() {
        assertEquals("5 больше 3", NumberComparison.compareNumbers(5, 3));
    }

    @Test
    public void testCompareNumbers_Lesser() {
        assertEquals("2 меньше 4", NumberComparison.compareNumbers(2, 4));
    }

    @Test
    public void testCompareNumbers_Equal() {
        assertEquals("7 равно 7", NumberComparison.compareNumbers(7, 7));
    }

    @Test
    public void testCompareNumbers_Negative() {
        assertEquals("-1 меньше 1", NumberComparison.compareNumbers(-1, 1));
    }

    @Test
    public void testCompareNumbers_NegativeEqual() {
        assertEquals("-2 равно -2", NumberComparison.compareNumbers(-2, -2));
    }
}
