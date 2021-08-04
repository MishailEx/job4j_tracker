package ru.job4j.build;

public class Car {
    private String brand;
    private String name;
    private int year;
    private String color;
    private String type;
    private double power;
    private int amountDoors;

    static class Builder {
        private String brand;
        private String name;
        private int year;
        private String color;
        private String type;
        private double power;
        private int amountDoors;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildYear(int year) {
            this.year = year;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildType(String type) {
            this.type = type;
            return this;
        }

        Builder buildPower(double power) {
            this.power = power;
            return this;
        }

        Builder buildAmountDoors(int amountDoors) {
            this.amountDoors = amountDoors;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.name = name;
            car.year = year;
            car.color = color;
            car.type = type;
            car.power = power;
            car.amountDoors = amountDoors;
            return car;
        }
    }

    @Override
    public String toString() {
        return "Car{" + "brand='" + brand + '\'' + ", name='" + name + '\''
                + ", year=" + year + ", color='" + color + '\''
                + ", type='" + type + '\'' + ", power=" + power
                + ", amountDoors=" + amountDoors + '}';
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildBrand("Honda")
                .buildName("Civic")
                .buildYear(2015)
                .buildColor("Blue")
                .build();
        System.out.println(car);
    }
}

