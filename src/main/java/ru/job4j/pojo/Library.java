package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {

        Book engVocabulary = new Book("English Vocabulary", 500);
        Book itVocabulary = new Book("Itaian Vocabulary", 450);
        Book gerVocabulary = new Book("German Vocabulary", 480);
        Book clean = new Book("Clean code", 430);
        Book[] books = new Book[4];
        books[0] = engVocabulary;
        books[1] = itVocabulary;
        books[2] = gerVocabulary;
        books[3] = clean;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + ": with " + book.getPages() + " pages.");
        }
        System.out.println("\n\nChange first and last books\n");
        books[0] = clean;
        books[3] = engVocabulary;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + ": with " + book.getPages() + " pages.");
        }
        System.out.println("\n\nPrint books with a name - Clean code\n");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + ": with " + book.getPages() + " pages.");
            }
        }
    }
}
