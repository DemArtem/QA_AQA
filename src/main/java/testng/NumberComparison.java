package testng;
import java.util.Scanner;
public class NumberComparison {
    public static String compareNumbers(int number1, int number2) {
        if (number1 > number2) {
            return number1 + " больше " + number2;
        } else if (number1 < number2) {
            return number1 + " меньше " + number2;
        } else {
            return number1 + " равно " + number2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое целое число: ");
        int number1 = scanner.nextInt();
        System.out.print("Введите второе целое число: ");
        int number2 = scanner.nextInt();
        String result = compareNumbers(number1, number2);
        System.out.println(result);
        scanner.close();
    }
}