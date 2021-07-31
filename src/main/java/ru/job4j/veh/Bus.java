package ru.job4j.veh;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поехал по дороге");
    }
}
