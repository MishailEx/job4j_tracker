package ru.job4j.oop;

public class Dentist extends Doctor {
    private int countAssist;

    public Dentist(String name, String surname, String education, int birthday, String department, int countAssist) {
        super(name, surname, education, birthday, department);
        this.countAssist = countAssist;
    }

    public String healtooth() {
        return null;
    }
}
