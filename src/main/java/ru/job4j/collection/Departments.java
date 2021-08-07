package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start = "".equals(start) ? el : start + "/" + el;
                tmp.add(start);
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
}
