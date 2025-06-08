package Task7;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class TriangleAreaCalculatorTest {
    @Test
    public void testCalculateArea_ValidTriangle() {
        double area = TriangleAreaCalculator.calculateArea(3, 4, 5);
        assertEquals(6.0, area, 0.0001);
    }

    @Test
    public void testCalculateArea_AnotherValidTriangle() {
        double area = TriangleAreaCalculator.calculateArea(6, 8, 10);
        assertEquals(24.0, area, 0.0001);
    }

    @Test
    public void testIsTriangle_ValidTriangle() {
        assertTrue(TriangleAreaCalculator.isTriangle(3, 4, 5));
        assertTrue(TriangleAreaCalculator.isTriangle(5, 6, 7));
    }

    @Test
    public void testIsTriangle_InvalidTriangle() {
        assertFalse(TriangleAreaCalculator.isTriangle(1, 2, 3));
        assertFalse(TriangleAreaCalculator.isTriangle(1, 10, 12));
    }
}