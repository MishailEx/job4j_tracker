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
        Predicate<Person> predicateName = (var) -> var.getName().contains(key);
        Predicate<Person> predicateSurName = (var) -> var.getSurname().contains(key);
        Predicate<Person> predicatePhone = (var) -> var.getPhone().contains(key);
        Predicate<Person> predicateAddress = (var) -> var.getAddress().contains(key);
        Predicate<Person> combine = (var) -> (predicateSurName.or(predicateName.
                or(predicateAddress.or(predicatePhone)))).test(var);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
