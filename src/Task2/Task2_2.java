package Task2;
public class Task2_2 {
    public static void main(String[] args) {
        //1. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple
        printThreeWords();
        //2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите. Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0, то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
        checkSumSign();
        //3. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением. Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”, если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;
        printColor();
        //4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
        compareNumbers();
        //5. Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
        System.out.println(checkSumInRange(5, 3));
        //6. Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
        checkNumber(-2);
        //7. Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное. Замечание: ноль считаем положительным числом.
        System.out.println(isNegative(-8));
        //8. Напишите метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз;
        printString("Hello", 3);
        //9. Напишите метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        int year = 2025;
        checkLeapYear(year);
        //10. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] array10 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        replaceElements(array10);
        //11. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
        int[] array11 = new int[100]; // Создаем пустой массив длиной 100
        fillArray(array11);
        //12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] array12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyLessThanSix(array12);
        //13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
        int size = 5; // Размерность массива (количество строк и столбцов)
        int[][] array13 = new int[size][size]; // Создаем квадратный двумерный массив
        fillDiagonal(array13);
        //14. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.
        int len = 6;
        int initialValue = 11;
        int[] array14 = new int[len];
        completeArray(array14, len, initialValue);
    }

    //1
    public static void printThreeWords() {
        System.out.println("Orange\n" + "Banana\n" + "Apple");
    }

    //2
    public static void checkSumSign() {
        int a = 1;
        int b = 2;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //3
    public static void printColor() {
        int value = 145;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    //4
    public static void compareNumbers() {
        int a = 14;
        int b = 22;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    //5
    public static boolean checkSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    //6
    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    //7
    public static boolean isNegative(int number) {

        return number < 0;
    }

    //8
    public static void printString(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    //9
    public static void checkLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year + " год является високосным.");
                } else {
                    System.out.println(year + " год не является високосным.");
                }
            } else {
                System.out.println(year + " год является високосным.");
            }
        } else {
            System.out.println(year + " год не является високосным.");
        }
    }

    //10
    public static void replaceElements(int[] array10) {
        for (int i = 0; i < array10.length; i++) {
            array10[i] = (array10[i] == 0) ? 1 : 0;
        }
        for (int value : array10) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    //11
    public static void fillArray(int[] array11) {
        for (int i = 0; i < array11.length; i++) {
            array11[i] = i + 1;
        }
        for (int value : array11) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    //12
    public static void multiplyLessThanSix(int[] array12) {
        for (int i = 0; i < array12.length; i++) {
            if (array12[i] < 6) {
                array12[i] *= 2;
            }
        }
        for (int value : array12) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    //13
    public static void fillDiagonal(int[][] array13) {
        for (int i = 0; i < array13.length; i++) {
            array13[i][i] = 1;
            array13[i][array13.length - 1 - i] = 1;
        }
        for (int[] row : array13) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    //14
    public static void completeArray(int[] array14, int len, int initialValue) {
        for (int i = 0; i < len; i++) {
            array14[i] = initialValue;
        }
        for (int value : array14) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

}