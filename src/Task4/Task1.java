package Task4;
/*
Создать классы Собака и Кот с наследованием от класса Животное.
Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
Добавить подсчет созданных котов, собак и животных.
Расширить задачу, добавив для котов возможность кушать из миски, выполнив следующие пункты:
Сделать так, чтобы в миске с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
Считаем, что если коту мало еды в миске, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
Создать массив котов и миску с едой, попросить всех котов покушать из этой миски и потом вывести информацию о сытости котов в консоль.
Добавить метод, с помощью которого можно было бы добавлять еду в миску
 */
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
        return super.name;
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
        return super.name;
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