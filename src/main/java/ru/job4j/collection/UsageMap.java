package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("dcs@dfds.ru", "Oleg Ivanov");
        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }
}
