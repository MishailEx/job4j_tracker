package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> predicateName = (p) -> p.getName().contains(key);
        Predicate<Person> predicateSurName = (p) -> p.getSurname().contains(key);
        Predicate<Person> predicatePhone = (p) -> p.getPhone().contains(key);
        Predicate<Person> predicateAddress = (p) -> p.getAddress().contains(key);
        Predicate<Person> combine = (p) -> (predicateSurName.or(predicateName.
                or(predicateAddress.or(predicatePhone)))).test(p);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
