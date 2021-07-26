package ru.job4j.Veh;

import ru.job4j.Veh.Vehicle;

public class Plan implements Vehicle {
    @Override
    public void move() {
        System.out.println("Полетел");
    }
}
