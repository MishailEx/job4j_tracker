package ru.job4j.oop;

public class Doctor extends Profession {
    private String department;

    public Doctor(String name, String surname, String education, int birthday, String department) {
        super(name, surname, education, birthday);
        this.department = department;
    }

    public Diagnosis heal(Pacient pacient) {
        return null;
    }

}
