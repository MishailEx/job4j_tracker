package ru.job4j.oop;

public class Surgeon extends Doctor {
    private int salary;

    public Surgeon(String name, String surname, String education, int birthday, String department, int salary) {
        super(name, surname, education, birthday, department);
        this.salary = salary;
    }

    public boolean operation() {
        return false;
    }
}
