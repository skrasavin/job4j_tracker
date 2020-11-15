package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.hamcrest.core.IsNull;

import javax.sound.midi.Track;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void showAllActions() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("First Item"));
        tracker.add(new Item("Second Item"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(out));
        actions.add(new ExitAction(out));

        new StartUI(out).init(in, tracker, actions);
        System.out.println(actions.get(0));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "==== Show all items ====" + System.lineSeparator() +
                        "1.First Item" + System.lineSeparator() +
                        "2.Second Item" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }


    @Test
    public void whenReplaceItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", "1", replacedName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction());
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        Item item1 = tracker.add(new Item("Replaced item1"));
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction());
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(1), is(IsNull.nullValue()));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("First Item"));
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find item by id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "==== Find item by id ====" + System.lineSeparator() +
                        "id=1, name=First Item" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find item by id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("First Item"));
        Input in = new StubInput(
                new String[]{"0", "First Item", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find items by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "==== Find items by name ====" + System.lineSeparator() +
                        "id=1, name=First Item" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find items by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        Tracker tracker = new Tracker();
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"9", "0"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        Tracker tracker = new Tracker();

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }
}