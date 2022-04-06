package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String operation;

    public Surgeon(String operation) {
        super();
        this.operation = operation;
    }

    public Surgeon(String name, String operation) {
        super(name);
        this.operation = operation;
    }

    public Surgeon(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public String whatOperation(String operation) {
        return "name of operation";
    }
}
