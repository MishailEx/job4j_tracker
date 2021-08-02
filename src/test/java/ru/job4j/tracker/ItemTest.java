package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ItemTest {
    @Test
    public void sortById() {
        Item item = new Item(2, "Andrey");
        Item item2 = new Item(3, "Oleg");
        Item item3 = new Item(1, "Boris");
        List<Item> items = Arrays.asList(item, item2, item3);
        items.sort(new SortedById());
        assertThat(item3, is(items.get(0)));
    }

    @Test
    public void reverseSortById() {
        Item item = new Item(2, "Andrey");
        Item item2 = new Item(3, "Oleg");
        Item item3 = new Item(1, "Boris");
        List<Item> items = Arrays.asList(item, item2, item3);
        items.sort(Collections.reverseOrder(new SortedById()));
        assertThat(item2, is(items.get(0)));
    }

    @Test
    public void reverseSortByName() {
        Item item = new Item(2, "Andrey");
        Item item2 = new Item(3, "Oleg");
        Item item3 = new Item(1, "Boris");
        List<Item> items = Arrays.asList(item, item2, item3);
        items.sort(Collections.reverseOrder(new SortedByName()));
        assertThat(item2, is(items.get(0)));
    }

    @Test
    public void sortByName() {
        Item item = new Item(2, "Andrey");
        Item item2 = new Item(3, "Oleg");
        Item item3 = new Item(1, "Boris");
        List<Item> items = Arrays.asList(item, item2, item3);
        items.sort(new SortedByName());
        assertThat(item, is(items.get(0)));
    }

}