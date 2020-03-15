package com.Super135;

import java.util.Scanner;

public class Main {

    public static void varTypes (){
        byte b = Byte.MAX_VALUE;
        int i = Integer.MAX_VALUE;
        short s = Short.MAX_VALUE;
        long l = Short.MAX_VALUE;
        float f = Float.MAX_VALUE;
        double d = Double.MAX_VALUE;
        boolean t = true;
        System.out.println("byte : " +b);
        System.out.println("int : " +i);
        System.out.println("sort : " +s);
        System.out.println("long : " +l);
        System.out.println("float : " +f);
        System.out.println("double : " +d);
        System.out.println("boolean : " +t);
    }

    public static double express(double a, double b, double c, double d){
        return (a * (b + (c / d)));
    }

    public static boolean ifFun(double a, double b){
        if (a+b>=10 & a+b<=20){
            return true;
        } else return false;
    }

    public static void whatNumber1(int i){
        if (i>=0){
            System.out.println("Вы ввели положительное число");
        } else System.out.println("Вы ввели отрицательное число");
    }

    public static boolean whatNumber2(int i){
        if (i>=0){
            return false;
        } else return true;
    }

    public static void userName(String name){
        System.out.println("Привет, "+name+"!");
    }

    public static void leapYear(long year) {
        if ((year % 4 == 0) & ((year % 100 != 0) || (year % 400 == 0))) {
            System.out.println("Год " + year + " будует високосным");
        } else System.out.println("Год " + year + " не будет високосным");
    }
    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {
        double a, b, c, d;
        Scanner scanner = new Scanner(System.in);
        // 2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
        varTypes();
        // 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
        System.out.println("Введите число a");
        a = scanner.nextDouble();
        System.out.println("Введите число b");
        b = scanner.nextDouble();
        System.out.println("Введите число c");
        c = scanner.nextDouble();
        System.out.println("Введите число d");
        d = scanner.nextDouble();
        System.out.println("(a * (b + (c / d))) = " + express(a,b,c,d));
        // 4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
        System.out.println("Введите первое число");
        a = scanner.nextDouble();
        System.out.println("Введите второе число");
        b = scanner.nextDouble();
        System.out.println("Сумма чисел лежит в пределах[10,20]? "+ifFun(a,b));
        // 5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
        System.out.println("Введите целое число");
        whatNumber1(scanner.nextInt());
        // 6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
        System.out.println("Введите целое число");
        System.out.println(whatNumber2(scanner.nextInt()));
        // 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
        System.out.println("Введите Ваше имя");
        userName(scanner.next());
        // 8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        System.out.println("Введите год в формате YYYY");
        leapYear(scanner.nextInt());
    }
}