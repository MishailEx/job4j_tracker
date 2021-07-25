package ru.job4j.oop;

public class Engineer extends Profession {
    private String section;

    public Engineer(String name, String surname, String education, int birthday, String section) {
        super(name, surname, education, birthday);
        this.section = section;
    }

    public String timeEstimateOnProj() {
        return null;
    }
}
