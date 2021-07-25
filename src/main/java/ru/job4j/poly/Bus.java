package ru.job4j.poly;

public class Bus implements Transport, Vehicle{
    @Override
    public void go() {
        System.out.println("go");
    }

    @Override
    public void passenger(int countPass) {
        System.out.println(countPass + "passenger got on the bus");
    }

    @Override
    public double refill(double fuel) {
        double price = fuel * 48.24;
        return price;
    }

    @Override
    public void move() {
        System.out.println("Поехал по дороге");
    }
}
