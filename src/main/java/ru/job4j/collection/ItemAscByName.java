package ru.job4j.collection;

import ru.job4j.tracker.Item;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Comparator;

public class ItemAscByName implements Comparable<ItemAscByName> {

    private int id;
    private String name;

    public ItemAscByName(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemAscByName that = (ItemAscByName) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ItemAscByName{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(ItemAscByName other) {
        return name.compareTo(other.getName());
    }
}
