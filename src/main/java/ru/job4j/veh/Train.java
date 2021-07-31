package ru.job4j.veh;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поехал по рельсам");
    }
}
