package ru.job4j.function;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("Vlad", "Boris", "Oleg");
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
                Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return Integer.compare(right.length(), left.length());
        };
        str.sort(cmpText);
        str.forEach(System.out::println);
        str.sort(cmpDescSize);
        str.forEach(System.out::println);
    }
}
