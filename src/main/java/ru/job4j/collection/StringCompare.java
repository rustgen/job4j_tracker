package ru.job4j.collection;

import java.util.Comparator;
import java.util.Map;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int sym = 0;
        if (left.length() == right.length()) {
            for (int i = 0; i < left.length(); i++) {
                if (left.charAt(i) == right.charAt(i)) {
                    sym = 0;
                } else {
                    sym = left.charAt(i) > right.charAt(i) ? left.charAt(i) : right.charAt(i);
                    break;
                }
            }
        }
        if (left.length() < right.length()) {
            for (int i = 0; i < left.length(); i++) {
                if (left.charAt(i) == right.charAt(i)) {
                    sym = -right.charAt(left.length());
                } else if (left.charAt(i) != right.charAt(i)) {
                    sym = left.charAt(i) > right.charAt(i) ? left.charAt(i) : right.charAt(i);
                    break;
                }
            }
        }
        if (left.length() > right.length()) {
            for (int i = 0; i < right.length(); i++) {
                if (left.charAt(i) == right.charAt(i)) {
                    sym = -left.charAt(right.length());
                } else if (left.charAt(i) != right.charAt(i)) {
                    sym = left.charAt(i) > right.charAt(i) ? -left.charAt(i) : -right.charAt(i);
                    break;
                }
            }
        }
        return sym;
    }
}
