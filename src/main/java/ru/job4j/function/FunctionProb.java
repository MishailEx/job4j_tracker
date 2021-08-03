package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionProb {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        Supplier<List<Double>> array = ArrayList::new;
        List<Double> list = array.get();
        BiConsumer<Integer, Integer> con = (i, i2) -> {
            for (double j = i; j < i2; j++) {
                list.add(func.apply(j));
            }
        };
        con.accept(start, end);
        return list;
    }
}
