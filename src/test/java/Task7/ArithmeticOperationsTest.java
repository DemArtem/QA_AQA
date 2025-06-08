package Task7;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ArithmeticOperationsTest {
    @Test
    public void testAdd() {
        assertEquals(5, ArithmeticOperations.add(2, 3));
        assertEquals(-1, ArithmeticOperations.add(2, -3));
        assertEquals(0, ArithmeticOperations.add(0, 0));
    }

    @Test
    public void testSubtract() {
        assertEquals(-1, ArithmeticOperations.subtract(2, 3));
        assertEquals(5, ArithmeticOperations.subtract(2, -3));
        assertEquals(0, ArithmeticOperations.subtract(0, 0));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, ArithmeticOperations.multiply(2, 3));
        assertEquals(-6, ArithmeticOperations.multiply(2, -3));
        assertEquals(0, ArithmeticOperations.multiply(0, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, ArithmeticOperations.divide(6, 3), 0.0001);
        assertEquals(-2.0, ArithmeticOperations.divide(6, -3), 0.0001);
        assertEquals(0.0, ArithmeticOperations.divide(0, 5), 0.0001);
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ArithmeticOperations.divide(1, 0);
        });
        assertEquals("Деление на ноль невозможно.", exception.getMessage());
    }
}