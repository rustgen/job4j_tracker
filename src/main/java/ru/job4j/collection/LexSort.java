package ru.job4j.collection;

import java.sql.Array;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {

        String[] first = left.split(".");
        String[] second = right.split(".");
        int leftW = 0;
        int rightW = 0;
        for (String word : first) {
            leftW = Integer.parseInt(word);
        }
        for (String word : second) {
            rightW = Integer.parseInt(word);
        }
        return Integer.compare(Integer.parseInt(first[0]), Integer.parseInt(second[0]));
    }
}
