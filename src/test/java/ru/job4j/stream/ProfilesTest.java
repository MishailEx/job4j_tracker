package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenNeedAddress() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Tverskaya", 5, 126)),
                new Profile(new Address("Moscow", "Lenina", 7, 6)),
                new Profile(new Address("SPB", "Moskovskiy", 70, 15))
        );
        Profiles profiles1 = new Profiles();
        List<Address> rsl = profiles1.collect(profiles);
        List<Address> expected = List.of(
                new Address("Moscow", "Tverskaya", 5, 126),
                new Address("Moscow", "Lenina", 7, 6),
                new Address("SPB", "Moskovskiy", 70, 15));
        assertThat(rsl, is(expected));
    }

}