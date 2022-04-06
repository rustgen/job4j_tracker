package ru.job4j.inheritance;

import javax.print.Doc;
import javax.print.DocFlavor;

public class Doctor extends Profession {

    private boolean diagnosis;

    public Doctor() {
    }

    public Doctor(String name) {
        super(name);
    }

    public Doctor(String name, boolean diagnosis) {
        super(name);
        this.diagnosis = diagnosis;
    }

    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public void setDiagnosis(boolean diagnosis) {
        this.diagnosis = diagnosis;
    }
}
