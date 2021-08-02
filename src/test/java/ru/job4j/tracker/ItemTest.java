package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ItemTest {
    @Test
    public void sortByIdAndReverseSort() {
        Item item = new Item(2, "Andrey");
        Item item2 = new Item(3, "Oleg");
        Item item3 = new Item(1, "Boris");
        List<Item> items = Arrays.asList(item, item2, item3);
        List<Item> itemsSort = Arrays.asList(item3, item, item2);
        List<Item> itemsSortReverse = Arrays.asList(item2, item, item3);
        items.sort(new SortedById());
        assertThat(itemsSort, is(items));
        items.sort(new SortReverseById());
        assertThat(itemsSortReverse, is(items));
    }
}