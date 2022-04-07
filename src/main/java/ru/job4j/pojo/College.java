package ru.job4j.pojo;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class College {
    public static void main(String[] args) {

        Student student = new Student();
        student.setFullName("Ivanov Ivan Ivanovich");
        student.setGroup(32);
        System.out.println("Student: " + student.getFullName() + ", group #" + student.getGroup() + ". Date of entrance is " + student.getEntrance());
    }
}
