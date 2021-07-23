package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Student {
    private String nameSurnameMiddleName;
    private String group;
    private LocalDate date;

    public String getNameSurnameMiddleName() {
        return nameSurnameMiddleName;
    }

    public void setNameSurnameMiddleName(String nameSurnameMiddleName) {
        this.nameSurnameMiddleName = nameSurnameMiddleName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
