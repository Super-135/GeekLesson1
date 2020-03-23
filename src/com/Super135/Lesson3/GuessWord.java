package com.Super135.Lesson3;

import java.util.Scanner;

public class GuessWord {
        // Функция Для вывода массива с #####
        public static void viewMassToStr(String[] q) {
            String str = "";

            for (int i = 0; i < q.length; i++) {
                if (q[i] != null) {
                    str = str + q[i];
                } else str = str + "#";
            }
            for (int i = q.length; i < 15; i++) {
                str = str + "#";
            }
            System.out.print(str);
        }

//        public static char[] mass(int q){
//            String[] mass = new String[q];
//
//            for (int i = 0; i < q; i++) {
//                mass[i] = "#";
//            }
//            return
//        }

        public static void main(String[] args) {
            String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                    "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
            int res = 0;
            boolean endGammes = false;
            String enterStr;
            int counter = 0;
            String[] massChar;
            int lengthmax=0;

            Scanner scan = new Scanner(System.in);
            res = (int) (Math.random() * (26));
            massChar = new String[words[res].length()];
            System.out.println("Угадайте фрукт из списка.");
            System.out.println("{\"apple\", \"orange\", \"lemon\", \"banana\", \"apricot\", \"avocado\", \"broccoli\", \"carrot\", \"cherry\", \"garlic\", \"grape\", \"melon\", \"leak\",\n" +
                    "                    \"kiwi\", \"mango\", \"mushroom\", \"nut\", \"olive\", \"pea\", \"peanut\", \"pear\", \"pepper\", \"pineapple\", \"pumpkin\", \"potato\"}");

            while (!endGammes) {
                enterStr = scan.next();
                if (enterStr == words[res]) {
                    System.out.println("Ура! Вы угадали. Это слово - " + res);
                    endGammes = true;
                } else {
                    // Если слово не угадано, ищем буквы которые стоят на своих местах
                    // я так понял что i-я буква введеного слова соответствует i-й букве угадываемого слова.
                    counter = 0;
                    if (enterStr.length() < massChar.length) {
                        lengthmax  = enterStr.length();
                    } else {lengthmax = massChar.length;}
                    for (int i = 0; i < lengthmax; i++) {
                        if (massChar[i] != null) {
                            counter = counter + 1;
                        } else if (enterStr.charAt(i) == words[res].charAt(i)) {
                            massChar[i] = String.valueOf(words[res].charAt(i));
                            counter = counter + 1;
                        }
                    }
                    if (endGammes || (counter == words[res].length())) {
                        System.out.println("Ура! Вы угадали. Это слово - " + words[res]);
                        endGammes = true;
                    } else {
                        System.out.println("Вы угадали такие буквы");
                        viewMassToStr(massChar);
                        System.out.println();
                        System.out.println("Продолжим");
                    }
                }
            }
        }
    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    public static void main(String[] args) {
//        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
//                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
//        int res = 0;
//        String resStr = "###############";
//        boolean endGammes = false;
//        String enterStr;
//
//        Scanner scan = new Scanner(System.in);
//        res = (int) (Math.random() * (26));
// //       resStr = words[res];
//        while (!endGammes) {
//            System.out.println("Введите число от 0 до 9");
//            enterStr = scan.next();
//            if (enterStr == words[res]) {
//                System.out.println("Ура! Вы угадали. Это слово - " + res);
//            } else {
//                for (int i = 0; i <15 ; i++) {
//                    if ((resStr.charAt(i) != '#') & (enterStr.charAt(i) != words[res].charAt(i))) {
//                        resStr.ins = '1';
//                    }
//                }
//            }
//        }
//
//    }
//}
