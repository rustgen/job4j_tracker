package ru.job4j.tracker;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String curentDayTime = item.getCreated().format(formatter);
        System.out.println(curentDayTime);
    }
}
