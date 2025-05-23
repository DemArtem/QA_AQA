package Task4;

interface Shape {
    // Метод для расчета площади
    double area();

    // Метод для расчета периметра с дефолтной реализацией
    default double perimeter() {
        return 0; // Дефолтный метод, может быть переопределен
    }

    // Метод для получения цвета заливки
    String getFillColor();

    // Метод для получения цвета границ
    String getBorderColor();

    // Метод для вывода характеристик фигуры
    default void displayInfo() {
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("Площадь: " + area());
        System.out.println("Периметр: " + perimeter());
        System.out.println();
    }
}

class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double area() {
        double s = (sideA + sideB + sideC) / 2; // Полупериметр
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC)); // Формула Герона
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

public class Task2 {
    public static void main(String[] args) {
        Shape circle = new Circle(5, "Красный", "Черный");
        Shape rectangle = new Rectangle(4, 6, "Зеленый", "Синий");
        Shape triangle = new Triangle(3, 4, 5, "Желтый", "Фиолетовый");

        System.out.println("Информация о фигурах:");
        circle.displayInfo();
        rectangle.displayInfo();
        triangle.displayInfo();
    }
}
