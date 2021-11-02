package ru.job4j.tracker;

public class FFF {
    public static void main(String[] args) {
        String a = "d";
        String s = "d";
        System.out.println(a == s);
        String w = "d";
        System.out.println("d" == w);
        System.out.println(new String("d").intern() == new String("d").intern());
    }
}
