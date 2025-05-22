package Task3;
/*
1. Создать класс "Товар" с полями: название, дата производства, производитель, страна происхождения, цена, состояние бронирования покупателем.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Товар» написать метод, который выводит информацию об объекте в консоль.
2. Создать массив из 5 товаров.
 */
import java.math.BigDecimal;
import java.time.LocalDate;
public class Product {
    private String name;
    private LocalDate manufactureDate;
    private String manufacturer;
    private String countryOfOrigin;
    private BigDecimal price;
    private boolean reservationStatus;

    public Product(String name, LocalDate manufactureDate, String manufacturer,
                   String countryOfOrigin, BigDecimal price, boolean reservationStatus) {
        this.name = name;
        this.manufactureDate = manufactureDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.reservationStatus = reservationStatus;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Manufacture Date: " + manufactureDate);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Country of Origin: " + countryOfOrigin);
        System.out.println("Price: " + price);
        System.out.println("Reservation Status: " + (reservationStatus ? "Reserved" : "Available"));
    }

    public static void main(String[] args) {
        //Product product = new Product("Television", LocalDate.of(2025, 5, 1), "Samsung", "South Korea", new BigDecimal("5000.00"), false);
        //product.displayInfo();

        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", LocalDate.of(2025, 1, 22), "Samsung Corp.", "Korea", new BigDecimal("6687.45"), true);
        productsArray[1] = new Product("iPhone 14 Pro", LocalDate.of(2022, 9, 7), "Apple Inc.", "USA", new BigDecimal("2702.97"), false);
        productsArray[2] = new Product("Xiaomi Mi 11", LocalDate.of(2021, 2, 8), "Xiaomi", "China", new BigDecimal("731.71"), false);
        productsArray[3] = new Product("Sony WH-1000XM4", LocalDate.of(2020, 8, 10), "Sony", "Japan", new BigDecimal("1210.60"), true);
        productsArray[4] = new Product("Dell XPS 13", LocalDate.of(2024, 1, 25), "Dell", "USA", new BigDecimal("10477.39"), false);

        for (Product product : productsArray) {
            product.displayInfo();
        }
    }

}
