package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item i : items) {
            if (i.getName().contains(key)) {
                rsl.add(i);
            }
        }
        return items;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.indexOf(index) == id) {
                rsl = items.indexOf(index);
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
            items.remove(index);
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = items.indexOf(id);
        return index != -1 ? items.get(id) : null;
    }
}