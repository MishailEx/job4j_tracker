package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывающий пользователя
 * @author Michail
 * @version 1.0
 */
public class User {
    /**
     * хранит значение паспорта пользователя
     */
    private String passport;

    /**
     * хранит значение имени пользователя
     */
    private String username;

    /**
     * конструктор для инициализации паспрта и имени
     * @param passport принимает значение паспорта
     * @param username принимает значение имени
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод для получения значения пасспорта пользователя
     * @return значение паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * метод для изменения значения паспорта пользователя
     * @param passport значение которое необходимо установить
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     *Метод для получение значения имени пользователя
     * @return значение имени
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод для изменения значения имени пользователя
     * @param username значение которое необходимо установить
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод для корректоного сравнения аккаунтов
     * @param o передаваемый объект для сравнения
     * @return результат сравнения
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод для корректного определения хешкода
     * @return хэшкод
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
