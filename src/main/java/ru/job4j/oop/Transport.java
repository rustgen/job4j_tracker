package ru.job4j.oop;

import java.util.Arrays;

public class Transport {
    public static void main(String[] args) {

        Vehicle airbus = new Plane();
        Vehicle boeing = new Plane();
        Vehicle scania = new Bus();
        Vehicle mercedes = new Bus();
        Vehicle freight = new Train();
        Vehicle passenger = new Train();
        Vehicle[] transports = {airbus, boeing, scania, mercedes, freight, passenger};

        for (Vehicle v : transports) {
            v.move();
            v.habitat();
        }
    }
}
