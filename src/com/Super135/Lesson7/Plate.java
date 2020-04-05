package com.Super135.Lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }


    public void setFood(int food) {
        this.food = food;
    }
    //Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
    public void addFood(int food){
        this.food += food;
    }

    public int getFood() {
        return food;
    }
}
