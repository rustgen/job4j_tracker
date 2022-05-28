package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        String[] first = o1.split("\\.");
        String[] second = o2.split("\\.");
        for (String s : first) {
            for (String value : second) {
                rsl = value.compareTo(s);
                if (value.equals(s)) {
                    rsl = s.compareTo(value);
                    break;
                }
                break;
            }
        }
        return rsl;
    }
}
