package Task6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.
 */
class PhoneBook {
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
    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        phoneBook.putIfAbsent(surname, new ArrayList<>());
        phoneBook.get(surname).add(phoneNumber);
    }

    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, new ArrayList<>());
    }
}