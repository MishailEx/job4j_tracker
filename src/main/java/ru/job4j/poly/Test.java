package ru.job4j.poly;

import ru.job4j.Veh.Plan;
import ru.job4j.Veh.Train;
import ru.job4j.Veh.Vehicle;

public class Test {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle plan = new Plan();
        Vehicle[] array = {bus, train, plan};
        for (Vehicle exp : array) {
            exp.move();
        }
    }
}
