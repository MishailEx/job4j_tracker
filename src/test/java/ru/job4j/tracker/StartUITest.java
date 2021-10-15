package ru.job4j.tracker;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(new CreateAction(out),
                new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = Arrays.asList(new ReplaceAction(out),
                new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = Arrays.asList(new DeleteAction(out),
                new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().size(), is(0));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = Collections.singletonList(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllAction() {
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("item1"));
        Item item1 = tracker.add(new Item("item2"));
        Item[] items = {item, item1};
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        List<UserAction> actions = Arrays.asList(new FindAllAction(out),
                new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() + "0. Find all" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator() + item + System.lineSeparator()
                        + item1 + System.lineSeparator() + "Menu." + System.lineSeparator()
                        + "0. Find all" + System.lineSeparator() + "1. Exit"
                        + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameAction() {
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("item"));
        Item item1 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item"));
        List<Item> items = Arrays.asList(item, item3);
        Input in = new StubInput(new String[]{"0", "item", "1"});
        List<UserAction> actions = Arrays.asList(new FindByNameAction(out),
                new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() + "0. Find by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find items by name ====" + System.lineSeparator()
                        + item + System.lineSeparator() + item3
                        + System.lineSeparator() + "Menu." + System.lineSeparator()
                        + "0. Find by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIdItem() {
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("Find item1"));
        Item item2 = tracker.add(new Item("Find item2"));
        Item item3 = tracker.add(new Item("Find item3"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        List<UserAction> actions = Arrays.asList(new FindByIdAction(out),
                new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find by id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find item by id ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find by id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"5", "0" }
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = Collections.singletonList(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
                )
        );
    }
}