package testng;
import org.testng.Assert;
import org.testng.annotations.Test;
public class NumberComparisonTest {

    @Test
    public void testNumbersAreEqual() {
        String result = NumberComparison.compareNumbers(5, 5);
        Assert.assertEquals(result, "5 равно 5");
    }

    @Test
    public void testFirstNumberIsGreater() {
        String result = NumberComparison.compareNumbers(10, 5);
        Assert.assertEquals(result, "10 больше 5");
    }

    @Test
    public void testSecondNumberIsGreater() {
        String result = NumberComparison.compareNumbers(3, 7);
        Assert.assertEquals(result, "3 меньше 7");
    }

    @Test
    public void testNegativeNumbers() {
        String result = NumberComparison.compareNumbers(-5, -3);
        Assert.assertEquals(result, "-5 меньше -3");
    }

    @Test
    public void testPositiveAndNegative() {
        String result = NumberComparison.compareNumbers(5, -3);
        Assert.assertEquals(result, "5 больше -3");
    }
}