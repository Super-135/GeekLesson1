package com.Super135.Lesson5;


// 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;

public class Employes {

    private static int count;
    private String fio;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;
    private int id;

    // 2. Конструктор класса должен заполнять эти поля при создании объекта;
    public Employes(String fio, String position, String email, String phone, double salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        this.id = count++;

    }

    @Override
    public String toString() {
        return "Employes{" +
                "fio='" + fio + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    // 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    public void showEmployee() {
        System.out.println("" + fio + '\'' +
                ", Должность -'" + position + '\'' +
                ", email -'" + email + '\'' +
                ", телефон -'" + phone + '\'' +
                ", Зарплата -" + salary +
                ", возраст -" + age);
    }

    public int getAge() {
        return age;
    }
}
