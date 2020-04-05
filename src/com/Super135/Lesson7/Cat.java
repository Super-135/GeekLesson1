package com.Super135.Lesson7;

public class Cat {

    private String name;
    private int appetite;
    private boolean satiety;
    private int id;
    private static int count;
    private static final int rangeAppetite = 5;

    public Cat(String name) {
        this.name = name;
        this.satiety = false;
        this.id = count++;
        //Все котики разные и аппетит тоже должен отличаться.
        this.appetite = 10 + (int) (Math.random() * (rangeAppetite+1));
    }

    public void feed(Plate p){
        //  Из методички
        //  4.Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
        //  то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
        if (this.appetite <= p.getFood()){
            this.satiety = true;
            p.setFood(p.getFood()-this.appetite);
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", satiety=" + satiety +
                ", id=" + id +
                '}';
    }
}
