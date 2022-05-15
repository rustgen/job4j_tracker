package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.collection.ItemAscByName;
import ru.job4j.collection.ItemDescByName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void compareToAsc() {
        List<Item> items = Arrays.asList(
                new Item("First"),
                new Item("Second"),
                new Item("Third")
        );
        Collections.sort(items, new ItemAscByName());

        List<Item> expected = Arrays.asList(
                new Item("First"),
                new Item("Second"),
                new Item("Third")
        );
        Assert.assertThat(expected, is(items));
    }

    @Test
    public void compareToDesc() {
        List<Item> items = Arrays.asList(
                new Item("First"),
                new Item("Second"),
                new Item("Third")
        );
        Collections.sort(items, new ItemDescByName());

        List<Item> expected = Arrays.asList(
                new Item("Third"),
                new Item("Second"),
                new Item("First")
        );
        Assert.assertThat(expected, is(items));
    }
}