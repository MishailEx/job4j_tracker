package ru.job4j.poly;

public interface Transport {
    void go();

    void passenger(int countPass);

    double refill(double fuel);
}
