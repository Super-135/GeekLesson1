package com.Super135.Lesson6;

public class Animal {

    protected int id;
    protected String name;
    protected int run;
    protected int swim;
    protected double jump;
    private static int count;
    // Дельты для разброс в ограничениях.
    // (5 * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м. )
    private static final int rangeRun = 200; //+-100
    private static final int rangeSwim = 10; //+- 5
    private static final double rangeJump = 0.5; // +- 0.25


    public Animal(String name) {
        this.id = count++;
        this.name = name;
    }

    public void setRun(int run) {
        this.run = run + (int) (Math.random() * (rangeRun+1));
    }

    public void setSwim(int swim) {
        this.swim = swim + (int) (Math.random() * (rangeSwim+1));
    }

    public void setJump(double jump) {
        this.jump = jump + (Math.random()* (rangeJump));
    }
    //4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true)
    public void run(int run) {
        if (this.run >= run) {
            System.out.println(name + " -> пробежал");
        } else System.out.println(name + " -> не пробежал");
    }

    public void swim(double swim) {
        if (this.swim >= swim) {
            System.out.println(name + " -> переплыл");
        } else System.out.println(name + " -> не переплыл");
    }

    public void jump(double jump) {
        if (this.jump >= jump) {
            System.out.println(name + " -> перепрыгнул");
        } else System.out.println(name + " -> не перепрыгнул");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", run=" + run +
                ", swim=" + swim +
                ", jump=" + String.format("%.2f", jump) +
                '}';
    }
}
