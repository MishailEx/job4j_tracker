package ru.job4j.tracker;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void whenAdd() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item("one");
        hbmTracker.add(item);
        List<Item> all = hbmTracker.findAll();
        assertEquals(item, all.get(0));
    }

    @Test
    public void whenFindAll() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item("one");
        Item item2 = new Item("two");
        hbmTracker.add(item);
        hbmTracker.add(item2);
        assertEquals(List.of(item, item2), hbmTracker.findAll());
    }

    @Test
    public void whenDelete() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item("one");
        hbmTracker.add(item);
        hbmTracker.delete(1);
        List<Item> all = hbmTracker.findAll();
        assertThat(all, IsEmptyCollection.empty());
    }

    @Test
    public void whenFindById() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item("one");
        hbmTracker.add(item);
        Item item2 = hbmTracker.findById(1);
        assertEquals(item2.getName(), "one");
    }

    @Test
    public void whenUpdate() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item("one");
        Item item2 = new Item("two");
        hbmTracker.add(item);
        hbmTracker.replace(item.getId(), item2);
        Item item3 = hbmTracker.findById(1);
        assertEquals(item3.getName(), "two");
    }

    @Test
    public void whenFindByName() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item("one");
        hbmTracker.add(item);
        List<Item> all = hbmTracker.findByName("one");
        assertEquals(all.size(), 1);
        assertEquals(item, all.get(0));
    }

}