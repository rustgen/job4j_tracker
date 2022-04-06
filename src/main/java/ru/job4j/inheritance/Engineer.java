package ru.job4j.inheritance;

public class Engineer extends Profession {

    private boolean design;

    public boolean layout(Project project) {
        return design;
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
