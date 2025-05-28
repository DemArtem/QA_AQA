package Task6;
import java.util.List;
public class MainPhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "+375(29)567-87-09");
        phoneBook.add("Иванов", "+375(33)864-07-93");
        phoneBook.add("Петров", "+375(25)573-90-76");
        phoneBook.add("Сидоров", "+375(29)784-00-56");

        List<String> ivanovPhones = phoneBook.get("Иванов");
        System.out.println("Телефоны Иванова: " + ivanovPhones);

        List<String> petrovPhones = phoneBook.get("Петров");
        System.out.println("Телефоны Петрова: " + petrovPhones);

        List<String> sidorovPhones = phoneBook.get("Сидоров");
        System.out.println("Телефоны Сидорова: " + sidorovPhones);
    }
}