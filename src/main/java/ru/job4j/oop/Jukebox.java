package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже" + System.lineSeparator()
                    + "Пешеходы по лужам," + System.lineSeparator() + "А вода по асфальту рекой.");
        } else if (position == 2) {
            System.out.println("Пусть бегут неуклюже" + System.lineSeparator()
                    + "Пешеходы по лужам," + System.lineSeparator() + "А вода по асфальту рекой.");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        jukebox.music(1);

    }
}
