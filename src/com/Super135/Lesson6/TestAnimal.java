package com.Super135.Lesson6;

public class TestAnimal {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Вася");
        Cat cat2 = new Cat("Мурка");
        Cat cat3 = new Cat("Демон");
        Dog dog1 = new Dog("Шарик");
        Dog dog2 = new Dog("Дружок");
        Dog dog3 = new Dog("Пончик");

        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat3);
        System.out.println(dog1);
        System.out.println(dog2);
        System.out.println(dog3);

        cat1.run(300);
        dog2.run(300);
        cat2.swim(1);
        dog1.swim(3);
        cat3.jump(1);
        dog3.jump(1);

    }
}
