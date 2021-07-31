package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setNameSurnameMiddleName("Олег Александрович Иванов");
        student.setGroup("2 A");
        student.setDate(LocalDate.of(2021, 02, 22));
        System.out.println(student.getNameSurnameMiddleName() + " из группы "
                + student.getGroup() + " поступивший " + student.getDate());
    }
}
