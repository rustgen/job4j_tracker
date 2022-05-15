package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.collection.ItemAscByName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void compareToAsc() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "First"));
        items.add(new Item(2, "Second"));
        items.add(new Item(3, "Third"));
        Collections.sort(items);

        List<Item> expected = new ArrayList<>();
        items.add(new Item(1, "First"));
        items.add(new Item(2, "Second"));
        items.add(new Item(3, "Third"));
        Assert.assertEquals(expected, equals(Collections.sort(items)));
    }

    @Test
    public void compareToAsc() {
        List<Item> items = Arrays.asList(
                new Item( "First"),
                new Item( "Second"),
                new Item("Third")
        );
//        items.add(new Item( "First"));
//        items.add(new Item( "Second"));
//        items.add(new Item("Third"));
        Collections.sort(items);

        List<Item> expected = new ArrayList<>();
        items.add(new Item(1, "First"));
        items.add(new Item(2, "Second"));
        items.add(new Item(3, "Third"));
        Assert.assertEquals(expected, equals(items));
    }
}