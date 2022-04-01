package ru.job4j.oop;

public class Ball {
    public void tryRun(boolean eaten) {
        if (eaten) {
            System.out.println("колобок съеден");
        } else {
            System.out.println("колобок сбежал");
        }
    }
}
