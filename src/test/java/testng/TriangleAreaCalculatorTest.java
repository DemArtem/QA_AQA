package testng;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TriangleAreaCalculatorTest {
    @Test
    public void testCalculateArea_ValidTriangle() {
        double area = TriangleAreaCalculator.calculateArea(3, 4, 5);
        Assert.assertEquals(area, 6.0, 0.0001);
    }

    @Test
    public void testCalculateArea_AnotherValidTriangle() {
        double area = TriangleAreaCalculator.calculateArea(6, 8, 10);
        Assert.assertEquals(area, 24.0, 0.0001);
    }

    @Test
    public void testIsTriangle_ValidTriangle() {
        Assert.assertTrue(TriangleAreaCalculator.isTriangle(3, 4, 5));
        Assert.assertTrue(TriangleAreaCalculator.isTriangle(5, 6, 7));
    }

    @Test
    public void testIsTriangle_InvalidTriangle() {
        Assert.assertFalse(TriangleAreaCalculator.isTriangle(1, 2, 3));
        Assert.assertFalse(TriangleAreaCalculator.isTriangle(1, 10, 12));
    }
}