package ru.job4j.oop;

public class Programmer extends Engineer {
    private String post;

    public Programmer(String name, String surname, String education, int birthday, String section, String post) {
        super(name, surname, education, birthday, section);
        this.post = post;
    }

    public void writeProgram() {
    }
}
