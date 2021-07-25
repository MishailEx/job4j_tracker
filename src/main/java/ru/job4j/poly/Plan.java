package ru.job4j.poly;

public class Plan implements Vehicle {
    @Override
    public void move() {
        System.out.println("Полетел");
    }
}
