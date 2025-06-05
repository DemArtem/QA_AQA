package Task7;
import java.util.Scanner;
public class ArithmeticOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое целое число: ");
        int number1 = scanner.nextInt();
        System.out.print("Введите второе целое число: ");
        int number2 = scanner.nextInt();

        // Сложение
        int sum = number1 + number2;
        System.out.println("Сумма: " + sum);

        // Вычитание
        int difference = number1 - number2;
        System.out.println("Разность: " + difference);

        // Умножение
        int product = number1 * number2;
        System.out.println("Произведение: " + product);

        // Деление с проверкой на ноль
        if (number2 != 0) {
            double quotient = (double) number1 / number2;
            System.out.println("Частное: " + quotient);
        } else {
            System.out.println("Деление на ноль невозможно.");
        }
        scanner.close();
    }

    public int add(int i, int i1) {
        return 0;
    }

    public int subtract(int i, int i1) {
        return 0;
    }

    public int multiply(int i, int i1) {
        return 0;
    }

    public double divide(int i, int i1) {
        return 0;
    }
}