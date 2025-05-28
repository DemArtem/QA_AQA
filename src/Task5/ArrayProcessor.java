package Task5;
/*
Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета.
Напишите код для генерации и поимки ArrayIndexOutOfBoundsException.
 */
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class ArrayProcessor {

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4x4");
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String[][] validArray = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };

        String[][] invalidArray = {
            {"1", "2", "3", "4"},
            {"5", "6", "seven", "8"}, // Неверные данные
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };

        String[][] wrongSizeArray = {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"}
        };

        try {
            System.out.println("Сумма элементов валидного массива: " + processArray(validArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Сумма элементов невалидного массива: " + processArray(invalidArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Сумма элементов массива неправильного размера: " + processArray(wrongSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        // Генерация исключения ArrayIndexOutOfBoundsException
        try {
            int[] arr = new int[5];
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Исключение: " + e.getMessage());
        }
    }
}