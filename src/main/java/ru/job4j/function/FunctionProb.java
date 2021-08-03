package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionProb {
   public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
      Supplier<List<Double>> array = ArrayList::new;
      List<Double> list = array.get();
      for (double i = start; i < end; i++) {
         list.add(func.apply(i));
      }
      return list;
   }
}
