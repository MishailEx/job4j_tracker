package ru.job4j.function;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streamm {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(2, 5, 8, 6, 7, 1);
        List<Integer> arrayTwo = array.stream()
                .filter((Integer) -> Integer > 0)
                .collect(Collectors.toList());
        arrayTwo.forEach(System.out::println);
    }
}
