package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        ArrayList<Character> v1 = new ArrayList<>();
        ArrayList<Character> v2 = new ArrayList<>();
        for (int i = 0; i < left.length(); i++) {
            v1.add(left.charAt(i));
        }
        for (int i = 0; i < right.length(); i++) {
            v2.add(right.charAt(i));
        }
        int min = Math.min(v1.size(), v2.size());
        for (int i = 0; i < min; i++) {
            if (v1.get(i) != v2.get(i)) {
                return Character.compare(v1.get(i), v2.get(i));
            }
        }
        return v1.size() - v2.size();
    }
}
