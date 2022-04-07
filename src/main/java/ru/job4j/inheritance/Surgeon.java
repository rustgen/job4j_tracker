package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String operation;

    public String makingOperation(Pacient pacient) {
        return operation;
    }

    public Surgeon(String name, String surname, String education, String birthday, boolean diagnosis, String operation) {
        super(name, surname, education, birthday, diagnosis);
        this.operation = operation;
    }

    public String whatOperation(String operation) {
        return "name of operation";
    }
}
