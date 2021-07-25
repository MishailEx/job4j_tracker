package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        String str = input.nextLine();
        int answer = new Random().nextInt(3);
        switch (answer) {
            case (0):
                System.out.println("да");
                break;
            case (1):
                System.out.println("нет");
                break;
            default:
                System.out.println("может быть");
                break;
        }
    }
}
