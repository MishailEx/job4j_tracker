package ru.job4j.oop;

public class Surgeon extends Doctor {
    private String name;
    private String surname;
    private String education;
    private int birthday;

    public Surgeon(String name, String surname, String education, int birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public boolean operation() {
    }
}
