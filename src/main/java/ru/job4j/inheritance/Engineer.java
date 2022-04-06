package ru.job4j.inheritance;

public class Engineer extends Profession {

    private boolean design;

    public Engineer() {
    }

    public Engineer(String name, boolean design) {
        super(name);
        this.design = design;
    }

    public Engineer(boolean design) {
        this.design = design;
    }

    public Engineer(String name, String education) {
        super(name, education);
    }

    public Engineer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public void setDesign() {
        this.design = design;
    }

    public boolean isDesign() {
        return design;
    }
}
