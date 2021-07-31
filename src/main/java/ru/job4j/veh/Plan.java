package ru.job4j.veh;

public class Plan implements Vehicle {
    @Override
    public void move() {
        System.out.println("Полетел");
    }
}
