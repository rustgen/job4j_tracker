package ru.job4j.lombok;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Item {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();
}
