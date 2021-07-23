package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book = new Book("mu-mu", 500);
        Book book1 = new Book("repka", 1000);
        Book book2 = new Book("capital", 13);
        Book book3 = new Book("Clean code", 624);
        Book[] lib = new Book[4];
        lib[0] = book;
        lib[1] = book1;
        lib[2] = book2;
        lib[3] = book3;
        for (int i = 0; i < lib.length; i++) {
            Book ex = lib[i];
            System.out.println("Name - " + ex.getName() + " страниц - " + ex.getCount());
        }
        Book temp = lib[0];
        lib[0] = lib[3];
        lib[3] = temp;
        System.out.println("замена книг");
        for (int i = 0; i < lib.length; i++) {
            Book ex = lib[i];
            System.out.println("Name - " + ex.getName() + " страниц - " + ex.getCount());
        }
        System.out.println("только книги Clean code");
        for (int i = 0; i < lib.length; i++) {
            Book ex = lib[i];
            if (ex.getName().equals("Clean code")) {
                System.out.println("Name - " + ex.getName() + " страниц - " + ex.getCount());
            }
        }
    }
}
