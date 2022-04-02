package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Есть ошибка: " + active);
        System.out.println("Номер ошибки - " + status);
        System.out.println("Сообщение об ошибке: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error error201 = new Error(true, 201, "Ошибка №201");
        Error error243 = new Error(true, 243, "Ошибка №243");
        Error error314 = new Error(true, 314, "Ошибка №314");
        error201.printInfo();
        error243.printInfo();
        error314.printInfo();
    }
}
