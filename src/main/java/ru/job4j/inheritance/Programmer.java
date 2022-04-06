package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String language;
    private boolean programming;

    public Programmer(String language) {
        this.language = language;
    }

    public Programmer(String name, String education) {
        super(name, education);
    }

    public Programmer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public boolean runProg(boolean programming) {
        return programming;
    }
}
