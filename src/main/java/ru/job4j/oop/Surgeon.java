package ru.job4j.oop;

public class Surgeon extends Doctor {

    public Surgeon(String name, String surname, String education, int birthday) {
        super(name, surname, education, birthday);
    }

    public boolean operation() {
        return false;
    }
}
