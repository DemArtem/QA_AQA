package Task7;
import java.util.Scanner;
//совершающую арифметические действия с двумя целыми числами (сложение, вычитание, деление и умножение);
public class ArithmeticOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое целое число: ");
        int number1 = scanner.nextInt();
        System.out.print("Введите второе целое число: ");
        int number2 = scanner.nextInt();

        // Сложение
        int sum = add(number1, number2);
        System.out.println("Сумма: " + sum);

        // Вычитание
        int difference = subtract(number1, number2);
        System.out.println("Разность: " + difference);

        // Умножение
        int product = multiply(number1, number2);
        System.out.println("Произведение: " + product);

        // Деление с проверкой на ноль
        if (number2 != 0) {
            double quotient = divide(number1, number2);
            System.out.println("Частное: " + quotient);
        } else {
            System.out.println("Деление на ноль невозможно.");
        }
        scanner.close();
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }
        return (double) a / b;
    }
}