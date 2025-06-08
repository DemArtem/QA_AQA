package testng;
import org.testng.Assert;
import org.testng.annotations.Test;
public class FactorialCalculatorTest {
    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(FactorialCalculator.factorial(0), 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        Assert.assertEquals(FactorialCalculator.factorial(5), 120);
        Assert.assertEquals(FactorialCalculator.factorial(10), 3628800);
    }

    @Test
    public void testFactorialOfOne() {
        Assert.assertEquals(FactorialCalculator.factorial(1), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, 
          expectedExceptionsMessageRegExp = "Факториал не определен для отрицательных чисел")
    public void testFactorialOfNegativeNumber() {
        FactorialCalculator.factorial(-1);
    }
}