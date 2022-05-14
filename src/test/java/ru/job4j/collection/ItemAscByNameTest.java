package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ItemAscByNameTest {

    @Test
    public void compareToAsc() {
        List<ItemAscByName> items = Arrays.asList(
                new ItemAscByName(1, "First"),
                new ItemAscByName(2, "Second"),
                new ItemAscByName(3, "Third")
                );
        Collections.sort(items);

        List<ItemAscByName> expected = Arrays.asList(
                new ItemAscByName(1, "First"),
                new ItemAscByName(2, "Second"),
                new ItemAscByName(3, "Third")
                );
        Assert.assertEquals(expected, equals(items));
    }
}