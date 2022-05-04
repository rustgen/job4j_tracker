package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        size++;
        return item;
    }

    public Item[] findAll() {
        return items.toArray(new Item[items.size()]);
    }

    public Item[] findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item i : items) {
            if (i.getName().contains(key)) {
                rsl.add(i);
            }
        }
        return rsl.toArray(new Item[rsl.size()]);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item i : items) {
            if (i.getId() == id) {
                rsl = i.getId();
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = items.indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = items.indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(findById(id));
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = items.indexOf(id);
        return index != -1 ? items.get(id) : null;
    }
}