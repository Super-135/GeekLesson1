package com.Super135.Lesson7;

import java.util.ArrayList;
import java.util.List;

public class TestCatAndPlate {



    public static void main(String[] args) {
        String[] names = {"Демон","Мелкий","Васька","Мурзик", "Чижик", "Пыжик"};
        int countCat = 10;
        List<Cat> cats = new ArrayList<>();
        //Создали тарелку
        Plate plate = new Plate(100);
        //Создали n-котиков
        for (int i = 0; i < countCat; i++) {
            cats.add(new Cat(names[(int) (Math.random() * (names.length))]));
        }
        //Давайте попробуем накормить котиков
        for (int i = 0; i < cats.size(); i++) {
            cats.get(i).feed(plate);
            System.out.print(cats.get(i));
            System.out.println(" --->  В тарелке осталось "+plate.getFood()+" еды");
        }
        plate.addFood(100);
        System.out.println(" --->  В тарелке осталось "+plate.getFood()+" еды");

    }
}
