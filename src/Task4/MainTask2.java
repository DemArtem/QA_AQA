package Task4;

public class MainTask2 {
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