package Task4;

class Animal {
    private static int animalCount = 0; // Счетчик всех животных
    String name;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}

class Dog extends Animal {
    private static int dogCount = 0; // Счетчик собак

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            super.run(distance);
        } else {
            System.out.println(getName() + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            super.swim(distance);
        } else {
            System.out.println(getName() + " не может проплыть " + distance + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }

    private String getName() {
        return super.name; // Получаем имя собаки
    }
}

class Cat extends Animal {
    private static int catCount = 0; // Счетчик котов
    private boolean isFull; // Поле сытости

    public Cat(String name) {
        super(name);
        this.isFull = false; // Кот изначально голоден
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            super.run(distance);
        } else {
            System.out.println(getName() + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать.");
    }

    public void eat(Bowl bowl) {
        if (bowl.getFoodAmount() > 0) {
            bowl.decreaseFood(1); // Кот ест 1 порцию еды
            this.isFull = true; // Кот сыт
            System.out.println(getName() + " покушал.");
        } else {
            System.out.println(getName() + " не может покушать, в миске недостаточно еды.");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }

    private String getName() {
        return super.name; // Получаем имя кота
    }
}

class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        this.foodAmount = initialFood;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("Добавлено " + amount + " еды в миску.");
        }
    }

    public void decreaseFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
        } else {
            System.out.println("Недостаточно еды в миске.");
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}

public class Main {
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
