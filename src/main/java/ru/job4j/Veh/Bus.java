package ru.job4j.Veh;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поехал по дороге");
    }
}
