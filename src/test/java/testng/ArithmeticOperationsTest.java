package testng;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ArithmeticOperationsTest {
    @Test
    public void testAdd() {
        Assert.assertEquals(ArithmeticOperations.add(2, 3), 5);
        Assert.assertEquals(ArithmeticOperations.add(2, -3), -1);
        Assert.assertEquals(ArithmeticOperations.add(0, 0), 0);
    }

    @Test
    public void testSubtract() {
        Assert.assertEquals(ArithmeticOperations.subtract(2, 3), -1);
        Assert.assertEquals(ArithmeticOperations.subtract(2, -3), 5);
        Assert.assertEquals(ArithmeticOperations.subtract(0, 0), 0);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(ArithmeticOperations.multiply(2, 3), 6);
        Assert.assertEquals(ArithmeticOperations.multiply(2, -3), -6);
        Assert.assertEquals(ArithmeticOperations.multiply(0, 5), 0);
    }

    @Test
    public void testDivide() {
        Assert.assertEquals(ArithmeticOperations.divide(6, 3), 2.0, 0.0001);
        Assert.assertEquals(ArithmeticOperations.divide(6, -3), -2.0, 0.0001);
        Assert.assertEquals(ArithmeticOperations.divide(0, 5), 0.0, 0.0001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Деление на ноль невозможно.")
    public void testDivideByZero() {
        ArithmeticOperations.divide(1, 0);
    }
}