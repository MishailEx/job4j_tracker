package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (start.equals("")) {
                    start = el;
                    tmp.add(start);
                } else {
                    tmp.add(start + "/" + el);
                    start = start + "/" + el;
                }
            }
        }
        return new ArrayList<>(tmp);

    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
        orgs.forEach(System.out::println);
    }

    public static void sortDesc(List<String> orgs) {
        Comparator<String> comparator = new DepDescComp();
        orgs.sort(comparator.thenComparing(Comparator.naturalOrder()));
        orgs.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String> d = Arrays.asList(
                "K1/SK1",
                "K1/SK2",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K2",
                "K2/SK2",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2");
        //  d = fillGaps(d);
        Comparator comparator = new DepDescComp();

        d.sort(Comparator.naturalOrder());
        d.forEach(System.out::println);
    }
}
