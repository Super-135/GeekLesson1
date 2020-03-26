package com.Super135.Lesson4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameXO {


    private final static char EMPTY = '_';
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';
    public static Boolean nobody = true;

    public void start(int size){
        char[][] gameBoard = new char[size][size];
        fillGameBoard(gameBoard);
        System.out.println("Игра крестики нолики. Вы играете за X");
        printGameBoard(gameBoard);
        System.out.println("Для хода, введите номер строки и столбца таблицы");
        boolean endGame = false;
        Scanner scn = new Scanner(System.in);
        while (! endGame){
            System.out.println("Ваш ход");
            int x, y;
            try {
                x = scn.nextInt();
                y = scn.nextInt();
                x--; y--;
                if(isValid(x,y,gameBoard)){
                    gameBoard[x][y] = DOT_X;
                    printGameBoard(gameBoard);
                    if (isVictory(gameBoard,DOT_X)) {
                        System.out.println("Победил Человек!!!");
                        break;
                    } else if (nobody) {
                        System.out.println("Ничья");
                    }
                    System.out.println("Компютер думает");
                    for (int i = 0; i < 5 ; i++) {
                        Thread.sleep(300);
                        System.out.print(".");
                    }
                    System.out.println();
                    movePC(gameBoard);
                    if (isVictory(gameBoard,DOT_O)) {
                        System.out.println("Победил Компьютер!!!");
                        break;
                    } else if (nobody) {
                        System.out.println("Ничья");
                    }
                }else {
                    System.out.println("Введите другое значение");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Вы ввели не цифры! Введите цифры");
                scn.next();
                continue;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Проверка победы человека и компа
    private boolean isVictory(char[][] gameBoard, char Player) {
        //TODO: Продумать проверку победы
        int winStr = 0, winCol = 0, winLeft1 = 0, winRight1 = 0, winRight2 = 0, winLeft2 = 0;
        int lengthVictory = 3;
        int counter = 1;
        if (gameBoard.length > 3 ){
            lengthVictory = 4;
        }
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j <gameBoard.length ; j++) {
                if (gameBoard[i][j] == EMPTY) {
                    nobody = false;
                }
                if (gameBoard[i][j] == Player){
                    winStr++;
                }else winStr = 0;

                if ((gameBoard[j][i] == Player)){
                    winCol++;
                }else winCol = 0;

                //заполняем одним циклом
                if ((j+i <= gameBoard.length-1) && (gameBoard[j][j+i] == Player)){
                    winLeft1++;
                }else  if ((j+i <= gameBoard.length-1) && (gameBoard[j][j+i] != Player)) {
                   winLeft1 = 0;
                }
                if ((j+i <= gameBoard.length-1) && (gameBoard[j+i][j] == Player)){
                    winLeft2++;

                }else if ((j+i <= gameBoard.length-1) && (gameBoard[j+i][j] != Player)) {
                    winLeft2 = 0;
                }
                if ((j+i <= gameBoard.length-1) && (gameBoard[j][gameBoard.length-j-1-i] == Player)){
                    winRight1++;
                }else  if ((j+i <= gameBoard.length-1) && (gameBoard[j][gameBoard.length-j-1-i] != Player)) {
                    winRight1 = 0;
                }

                if ((j+i <= gameBoard.length-1) && (gameBoard[j+i][gameBoard.length-j-1] == Player)){
                    winRight2++;
                }else if ((j+i <= gameBoard.length-1) && (gameBoard[j+i][gameBoard.length-j-1] != Player)) {
                    winRight2 = 0;
                }
                if (winStr == lengthVictory || winCol == lengthVictory || winLeft1 == lengthVictory || winLeft2 == lengthVictory || winRight1 == lengthVictory || winRight2 == lengthVictory){
                    return true;
                }
            }
            winCol = 0;
            winStr = 0;
            winLeft1 =0;
            winLeft2 =0;
            winRight1=0;
            winRight2=0;
        }
        return false;

    }

    // Ход компа. Он играет рандомно
    private void movePC(char[][] gameBoard) {
        //TODO: Продумать красивый ход игрока
        boolean end = true;
        while (end) {
            int x = (int) (Math.random() * (gameBoard.length));
            int y = (int) (Math.random() * (gameBoard.length));
            if (gameBoard[x][y] == EMPTY) {
                gameBoard[x][y] = DOT_O;
                printGameBoard(gameBoard);
                System.out.println(x +","+y);
                return;
            }
        }
    }

    // Проверка на корректный ввод со стороны игрока.
    private boolean isValid(int x, int y, char[][] gameBoard) {
        int len = gameBoard.length;
        if (x >= 0 && x < len && y >= 0 && y < len){
            if (gameBoard[x][y] == EMPTY){
                return true;
            }
        }
        return false;
    }
    //отрисовка поля с ходами игрока и компа
    private void printGameBoard(char[][] gameBoard) {
        int counter = 1;
        System.out.print("   ");
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print((i+1)+" ");
        }
        System.out.println();
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print(counter++ + " ");
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print("|"+gameBoard[i][j]);
            }
            System.out.println("|");
        }
    }
    //Обнуление массива для начала игры и заполнение констант для отрисовки поля
    private void fillGameBoard(char [][] gameBoard){
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = EMPTY;
            }
        }
    }

    public static void main(String[] args) {
        if (args != null && args.length == 1) {
            new GameXO().start(Integer.parseInt(args[0]));
        } else {
            new GameXO().start(5);
        }
    }
}
