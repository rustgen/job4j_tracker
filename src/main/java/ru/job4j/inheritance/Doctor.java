package ru.job4j.inheritance;

public class Doctor extends Profession {

    private boolean diagnosis;

    public boolean heal(Pacient pacient) {
        return diagnosis;
    }

    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public void setDiagnosis(boolean diagnosis) {
        this.diagnosis = diagnosis;
    }
}
