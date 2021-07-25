package ru.job4j.oop;

public class Builder extends Engineer {
    private int workHours;

    public Builder(String name, String surname, String education, int birthday, String section, int workHours) {
        super(name, surname, education, birthday, section);
        this.workHours = workHours;
    }

    public void buildHouse() {
    }
}
