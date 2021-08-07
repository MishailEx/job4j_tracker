package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] s = o1.split("/");
        String[] s2 = o2.split("/");
        if (o1.length() > o2.length()) {
            int rsl = -1;
            for (int i = 0; i < s2.length; i++) {
                rsl = s2[i].compareTo(s[i]);
                if (i > 0) {
                    rsl = s[i].compareTo(s2[i]);
                }
                if (rsl != 0) {
                    return rsl;
                }
            }
            if (rsl == 0) {
                return o1.compareTo(o2);
            }
        }
        if (o1.length() < o2.length()) {
            int rsl = -1;
            for (int i = 0; i < s.length; i++) {
                rsl = s2[i].compareTo(s[i]);
                if (i > 0) {
                    rsl = s[i].compareTo(s2[i]);
                }
                if (rsl != 0) {
                    return rsl;
                }
            }
            if (rsl == 0) {
               return o1.compareTo(o2);
            }
        }
        if (o1.length() == o2.length()) {
            int rsl = -1;
            for (int i = 0; i < s.length; i++) {
                rsl = s2[i].compareTo(s[i]);
                if (i > 0) {
                    rsl = s[i].compareTo(s2[i]);
                }
                if (rsl != 0) {
                    return rsl;
                }
            }
            if (rsl == 0) {
                return o1.compareTo(o2);
            }
        }
        return 0;
    }
}
