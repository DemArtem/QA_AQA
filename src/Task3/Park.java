package Task3;
import java.math.BigDecimal;
/*
3. Создать класс Park с внутренним классом, с помощью объектов которого можно
хранить информацию об аттракционах, времени их работы и стоимости.
 */
public class Park {
    private String name;
    private Attraction[] attractions;
    private int attractionCount;

    public Park(String name, int maxAttractions) {
        this.name = name;
        this.attractions = new Attraction[maxAttractions];
        this.attractionCount = 0;
    }

    public void addAttraction(String attractionName, String workingHours, BigDecimal price) {
        if (attractionCount < attractions.length) {
            attractions[attractionCount++] = new Attraction(attractionName, workingHours, price);
        } else {
            System.out.println("Невозможно добавить аттракцион");
        }
    }

    public void displayInfo() {
        System.out.println("Парк: " + name);
        System.out.println("Аттракционы:");
        for (int i = 0; i < attractionCount; i++) {
            attractions[i].displayInfo();
        }
    }

    private class Attraction {
        private String name;
        private String workingHours;
        private BigDecimal price;

        public Attraction(String name, String workingHours, BigDecimal price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void displayInfo() {
            System.out.println("  Название: " + name);
            System.out.println("  Время работы: " + workingHours);
            System.out.println("  Стоимость: " + price);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Park amusementPark = new Park("Развлекательный парк", 5);

        amusementPark.addAttraction("Американские горки", "10:00 - 20:00", new BigDecimal("10.00"));
        amusementPark.addAttraction("Колесо обозрения", "10:00 - 22:00", new BigDecimal("7.50"));
        amusementPark.addAttraction("Лабиринт", "10:00 - 19:00", new BigDecimal("5.00"));
        amusementPark.addAttraction("Детская площадка", "09:00 - 21:00", new BigDecimal("5.00"));
        amusementPark.addAttraction("Картинг", "11:00 - 21:00", new BigDecimal("20.00"));

        amusementPark.displayInfo();
    }
}