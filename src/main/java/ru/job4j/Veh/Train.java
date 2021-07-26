package ru.job4j.Veh;

import ru.job4j.Veh.Vehicle;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поехал по рельсам");
    }
}
