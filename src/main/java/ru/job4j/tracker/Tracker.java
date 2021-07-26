package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        return indexOf(id) != -1 ? items[indexOf(id)] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items[index] = item;
        }
        return rsl;
    }

    public boolean delete(int id) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
            rsl = true;
        }
        return rsl;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int sizeArray = 0;
        Item[] names = new Item[items.length];
        for (int i = 0; i < this.size; i++) {
            if (items[i].getName().equals(key)) {
                names[sizeArray++] = items[i];
            }
        }
        names = Arrays.copyOf(names, sizeArray);
        return names;
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item("first");
        Item item2 = new Item("second");
        tracker.add(item);
        tracker.add(item2);
        Item[] items1 = tracker.findAll();
        for (Item item1 : items1) {
            System.out.println(item1);
        }

    }
}