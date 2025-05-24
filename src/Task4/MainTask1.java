package Task4;

public class MainTask1 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Бобик");
        Cat cat1 = new Cat("Мурка");
        Cat cat2 = new Cat("Василиса");

        dog1.run(150);
        dog1.swim(5);
        cat1.run(150);
        cat1.swim(50); // Кот не умеет плавать

        Bowl bowl = new Bowl(2); // Миска с 2 порциями еды

        // Коты пытаются покушать
        cat1.eat(bowl);
        cat2.eat(bowl);

        // Проверяем сытость котов
        System.out.println("Мурка сыта: " + cat1.isFull());
        System.out.println("Василиса сыта: " + cat2.isFull());

        // Добавляем еду в миску и повторно пытаемся покормить
        bowl.addFood(2);
        cat2.eat(bowl);

        // Проверяем сытость кота снова
        System.out.println("Василиса сыта: " + cat2.isFull());

        // Выводим количество созданных животных
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
    }
}