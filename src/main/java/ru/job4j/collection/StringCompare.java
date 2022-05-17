package ru.job4j.collection;

import java.util.Comparator;
import java.util.Map;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int len = Math.min(left.length(), right.length());
        for (int i = 0; i < len; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                rsl = Character.compare(left.charAt(i), right.charAt(i));
                break;
            }
        }
        return rsl != 0 ? rsl : Integer.compare(left.length(), right.length());
    }
}
