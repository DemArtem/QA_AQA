package testng;
import java.util.Scanner;
public class TriangleAreaCalculator {
    public static double calculateArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        // Площадь по формуле Герона
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static boolean isTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину первой стороны треугольника: ");
        double a = scanner.nextDouble();
        System.out.print("Введите длину второй стороны треугольника: ");
        double b = scanner.nextDouble();
        System.out.print("Введите длину третьей стороны треугольника: ");
        double c = scanner.nextDouble();

        // Проверка на существование треугольника
        if (isTriangle(a, b, c)) {
            double area = calculateArea(a, b, c);
            System.out.printf("Площадь треугольника с длинами сторон %.2f, %.2f и %.2f равна %.2f%n", a, b, c, area);
        } else {
            System.out.println("Треугольник с такими сторонами не существует.");
        }
        scanner.close();
    }
}