package Task7;
import java.util.Scanner;
public class NumberComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое целое число: ");
        int number1 = scanner.nextInt();
        System.out.print("Введите второе целое число: ");
        int number2 = scanner.nextInt();
        if (number1 > number2) {
            System.out.println(number1 + " больше " + number2);
        } else if (number1 < number2) {
            System.out.println(number1 + " меньше " + number2);
        } else {
            System.out.println(number1 + " равно " + number2);
        }
        scanner.close();
    }
}