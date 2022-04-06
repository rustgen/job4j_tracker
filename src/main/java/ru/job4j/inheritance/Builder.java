package ru.job4j.inheritance;

public class Builder extends Engineer {

    private boolean building;

    public Builder(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public boolean newBuild(boolean building) {
        return building;
    }

    public boolean isBuilding() {
        return building;
    }
}
