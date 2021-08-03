package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .sorted(Comparator.comparing(profile -> profile.getAddress().getCity()))
                .distinct()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Tverskaya", 5, 126)),
                new Profile(new Address("Moscow", "Lenina", 7, 6)),
                new Profile(new Address("SPB", "Moskovskiy", 70, 15))
        );
        Profiles profiles1 = new Profiles();
        List<Address> rsl = profiles1.collect(profiles);
        rsl.forEach(System.out::println);
    }
}
