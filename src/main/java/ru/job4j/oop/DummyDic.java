package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return eng;
    }

    public static void main(String[] args) {
        DummyDic dic = new DummyDic();
        String word1 = dic.engToRus("car");
        System.out.println("Неизвестное слово. " + word1);
    }
}
