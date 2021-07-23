package ru.job4j.oop;

public class Dentist extends Doctor {
    private String name;
    private String surname;
    private String education;
    private int birthday;

    public Dentist(String name, String surname, String education, int birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String healtooth() {
    }
}
