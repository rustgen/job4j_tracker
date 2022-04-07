package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private boolean teeth;

    public boolean tooth(Pacient pacient) {
        return teeth;
    }

    public Dentist(String name, String surname, String education, String birthday, boolean diagnosis, boolean teeth) {
        super(name, surname, education, birthday, diagnosis);
        this.teeth = teeth;
    }

    public void setTeeth(boolean teeth) {
        this.teeth = teeth;
    }
}
