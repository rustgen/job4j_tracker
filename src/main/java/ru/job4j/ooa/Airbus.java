package ru.job4j.ooa;

public final class Airbus extends Aircraft {

    private static final int COUNT_ENGINE = 2;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        final int ALL_ENGINE = 4;
        System.out.println("Количество двигателей равно: " + (getName().equals("A380") ? ALL_ENGINE : COUNT_ENGINE));
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}
