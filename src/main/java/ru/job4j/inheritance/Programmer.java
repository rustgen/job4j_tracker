package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String language;

    public String useLanguage(String language) {
        return language;
    }

    public Programmer(String name, String surname, String education, String birthday, boolean design, String language) {
        super(name, surname, education, birthday, design);
        this.language = language;
    }

    public boolean runProg(boolean programming) {
        return programming;
    }
}
