package ru.job4j.oop;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - передвигается по рельсам");
    }

    @Override
    public void habitat() {
        System.out.println(getClass().getSimpleName() + ". Его среда обитания - железнодорожные пути.");
    }
}
