package com.Super135.Lesson3;

import java.util.Scanner;

public class GuessGamme {
    public static void main(String[] args) {
        System.out.println("Привет! Это игра угадайка. Я загадываю число 0 до 9. У тебя 3-и попыткиугадать. ПОЕХАЛИ!!!");
        boolean endGammes = false;
        int res = 0;
        int enterNum = 0;
        int maxNum = 10;
        Scanner scan = new Scanner(System.in);
        while (!endGammes) {
            res = (int) (Math.random() * (maxNum));
            for (int i = 0; i < 3; i++) {
                System.out.println("Введите число от 0 до 9");
                enterNum = scan.nextInt();
                if (enterNum == res) {
                    break;
                } else if (enterNum > res) {
                    System.out.println("Число больше загаданного.");
                } else if (enterNum < res) {
                    System.out.println("Число меньше загаданного.");
                }
            }
            if (enterNum == res) {
                System.out.println("Ура! Вы угадали. Это число - " + res);
            } else  System.out.println("Вы не угадали. Это число - " + res);
            // Если пользователь ввел и не 0 и не 1 мы его будем переспрашивыть пока он не научится отвечать точно на поставленный вопрос :):):):)
            while (!endGammes) {
                System.out.println("Повторить игру еще раз? \n 1 - да / 0 - нет");
                enterNum = scan.nextInt();
                if (enterNum == 0) {
                    System.out.println("Пока!");
                    endGammes = true;
                } else if (enterNum == 1) {
                    break;
                }
            }
        }
    }
}
