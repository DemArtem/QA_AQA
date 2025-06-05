package Task7;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class FactorialCalculatorTest {

    private final FactorialCalculator calculator = new FactorialCalculator();

    @Test
    void testFactorialOfZero() {
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    void testFactorialOfPositiveNumber() {
        assertEquals(120, calculator.factorial(5));
        assertEquals(720, calculator.factorial(6));
        assertEquals(40320, calculator.factorial(8));
    }

    @Test
    void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.factorial(-1);
        });
        assertEquals("Факториал отрицательного числа не определен", exception.getMessage());
    }
}