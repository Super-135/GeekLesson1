package com.Super135;

public class Lesson2 {
    //Вспомогательные функции
    // Для генерации целочисленных массивов любой размерности (начиная от 5 и случайными числами от 0 до maxNumber но не меньше 1)
    // Будем использовать во всех заданиях.
    public static int[] massInt(int sizeMass, int maxNumber){
        int [] resultMass;

        if (sizeMass < 5) {sizeMass = 5;}
        if (maxNumber < 1) {maxNumber = 1;}
        resultMass = new int[sizeMass];

        for (int i = 0; i < sizeMass; i++) {
            resultMass[i] = (int) (Math.random() * (maxNumber+1));
        }
        return resultMass;
    }

    // Выводим любой одномерный массив на экран красиво.
    public static void viewResult(int[] mass){
        if (mass.length > 0){System.out.print("[ ");}
        for (int i = 0; i < mass.length; i++) {
            System.out.printf("%3d" + " ", mass[i]);
        }
        if (mass.length >0){System.out.print("]");}
    }


    // Задание №1 Inversion 0 и 1
    public static int[] Inversion(int[] mass){
        int[] resultMass = new int [mass.length];
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] > 0) {
                resultMass[i] = 0;
            }  else resultMass[i] = 1;
        }
        return resultMass;
    }
    // Задание №2 arithmeticProgression +3
    public static void arithmeticProgression(){
        int[] mass = {0,0,0,0,0,0,0,0};
        for (int i = 0; i < mass.length; i++) {
            if (i == 0) {
                mass[i] = 0;
            } else mass[i] = mass[i - 1] + 3;
        }
        viewResult(mass);
    }

    // Задание №3 increaseMass
    public static void increaseMass(int[] mass){

        for (int i = 0; i < mass.length; i++) {
            if (mass[i] < 6) {
                mass[i] *= 2;
            }
        }
        viewResult(mass);
    }

    // Задание №4 diagonalArray
    public static void diagonalArray(){
        int sizeMass = 10;
        int[][] mass = new int[sizeMass][sizeMass];
        //заполняем одним циклом
        for (int i = 0; i < sizeMass; i++) {
            mass[i][sizeMass-i-1]=1;
            mass[i][i]=1;
        }
        //выводим двумя
        for (int i = 0; i < sizeMass; i++) {
            System.out.print("[ ");
            for (int j = 0; j < sizeMass; j++) {
                System.out.printf("%3d",mass[i][j]);
            }
            System.out.println(" ]");
        }
    }

    // Задание №5 maxMinMass
    public static void maxMinMass(int[] mass){
        int max = 0;
        int min = 0;
        for (int i = 0; i < mass.length; i++) {
            if (max < mass[i]) {
                max = mass[i];
            }
            if (min > mass[i]) {
                min = mass[i];
            }
        }
        System.out.println("Это наш массив");
        viewResult(mass);
        System.out.println("min = "+min+",   max = "+max);
    }
    // Задание №6 checkBalance
    public static void checkBalance(){
        int[] mass;
        int sumLeft = 0;
        int sumRight= 0;
        int i = 0;
        int j = 0;
        // если длинна массив не кратена 2-м то есть вероятность слева заехать на право
        // а с право на лево так что увеличим количество итераций вдвое но точно не пересечемся
        boolean ignoreRight= true;
        // верхний цикл будет выполняться пока мы не найдем СБАЛАНСИРОВАННЫЙ массив
        // внутренний цикл ищет баланс в массиве
        do {
            mass = new int[10];
            mass = massInt(10,10);
            if (sumLeft > 0){
                viewResult(mass);
                System.out.println(" -> false");
            }
            sumLeft = 0;
            sumRight= 0;
            i = 0;
            j = 0;
            do {
                ignoreRight = true;
                if (sumLeft <= sumRight) {
                    sumLeft = sumLeft + mass[i];
                    i = i + 1;
                    ignoreRight = false;
                }
                if (ignoreRight & (sumRight < sumLeft)) {
                    sumRight = sumRight + mass[mass.length - j - 1];
                    j = j + 1;
                }
            } while ((i + j) != mass.length);
        } while (sumRight != sumLeft);
        System.out.println("Ура нашли");
        viewResult(mass);
        System.out.println(" -> true");
    }

    // Задание №7.1 shiftN
    public static void shiftN1(int[] mass, int nPos){
        int buffer = 0;
        viewResult(mass);
        if (nPos < 0 ) {
            nPos = nPos*-1;
        } else {
            nPos = mass.length-nPos;
        }
        for (int i = nPos; i > 0; i--) {
            for (int j = 0; j < mass.length; j++) {
                if (j == 0) {
                    buffer = mass[j];
                }
                if (j != mass.length-1 ) {
                    mass[j] = mass[j + 1];
                } else {
                    mass[j] = buffer;
                }
            }
        }
       System.out.println();
       viewResult(mass);
    }

//  Тут должен был быть второй способ который работает не за (n**2), а n шагов. Но не успел.
//  Спасибо за задачку с **** звездочками. Мозг просто вскипел. Хоть я и программирую не первый год.
//  :)
//  правда не на JAVA.

//    // Задание №7.2 shiftN
//    public static void shiftN2(int[] mass, int nPos){
//        int buffer1 = 0;
//        int buffer2 = 0;
//        int buffer3 = 0;
//        int counter = 1;
//        int controlNpos = 0;
//        int currentPos = 0;
//        int currentPos2 = 0;
////        viewResult(mass);
//        currentPos = (mass.length-nPos+1);
//        while (counter != mass.length){
//            if ((currentPos+nPos) > mass.length){
//                currentPos2 =(currentPos+nPos)%mass.length;
//            } else currentPos2 = currentPos+nPos;
////            if (counter == 1) {
//                buffer2 = buffer1;
//                buffer1 = mass[currentPos2 - 1];
//
//            //} else
//            mass[currentPos2-1] = mass[currentPos-1];
//            if (currentPos + nPos > mass.length){
//                currentPos = (currentPos+nPos)%mass.length;
//            } else {
//                currentPos = currentPos + nPos;
//            }
//            counter++;
//        }
//
////        System.out.println();
////        viewResult(mass);
//    }


    public static void main(String[] args) {
        int sizeMass = 10;
        int maxNum = 10;
        int[] mass = new int[sizeMass];

//        1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;");
        System.out.println("Массив без инверсии");
        mass = massInt(sizeMass,1);
        viewResult(mass);
        System.out.println();
        System.out.println("Он же с инверсией");
        viewResult(Inversion(mass));
        System.out.println();
        System.out.println("------------------------------------------------------------------");
        System.out.println();

//        2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;");
        arithmeticProgression();
        System.out.println();
        System.out.println("------------------------------------------------------------------");
        System.out.println();

//        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2; зададимм его random-ом
        System.out.println("3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2; зададимм его random-ом");
        mass = massInt(sizeMass,maxNum);
        viewResult(mass);;
        System.out.println();
        increaseMass(mass);
        System.out.println();
        System.out.println("------------------------------------------------------------------");
        System.out.println();

//        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;");
        diagonalArray();
        System.out.println();
        System.out.println("------------------------------------------------------------------");
        System.out.println();

//        5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.println("5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);");
        mass = massInt(sizeMass,maxNum);
        maxMinMass(mass);
        System.out.println();
        System.out.println("------------------------------------------------------------------");
        System.out.println();

//        6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место,
//        в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
//        граница показана символами ||, эти символы в массив не входят.
        System.out.println("6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место,\n" +
                "в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,\n" +
                "граница показана символами ||, эти символы в массив не входят.");
        checkBalance();
        System.out.println();
        System.out.println("------------------------------------------------------------------");
        System.out.println();
//        7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
//        при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        System.out.println("7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),\n" +
                "при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.");
        int[] mass1 = {1,2,3,4,5,6,7,8,9,10,11};
        shiftN1(mass1,3);
    }
}
