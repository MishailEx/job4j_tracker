package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = 0;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] array = {"aaa", "bbb", "ccc"};
        try {
            indexOf(array, "fff");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
