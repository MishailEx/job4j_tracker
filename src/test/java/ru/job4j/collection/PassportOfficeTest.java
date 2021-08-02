package ru.job4j.collection;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addDuplicate() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen2 = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizen2);
        assertThat(office.get(citizen.getPassport()), is(citizen));
        assertThat(office.add(citizen2), is(false));
    }
}