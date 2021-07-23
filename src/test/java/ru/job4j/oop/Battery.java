package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load){
        this.load = load;
    }

    public void exchange(Battery another){
        this.load = this.load + another.load;
        another.load = 0;
    }

    public int getLoad(){
        return this.load;
    }

    public static void main(String[] args) {
        Battery battery = new Battery(10);
        Battery battery1 = new Battery(20);
        battery.exchange(battery1);
        System.out.println(battery.getLoad());
        System.out.println(battery1.getLoad());
    }
}
