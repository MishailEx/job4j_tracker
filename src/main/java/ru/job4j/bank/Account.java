package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает аккаунт юзера, хранящий
 * в себе реквизит и баланс
 * @author Michail
 * @version 1.0
 */
public class Account {
    /**
     * номер реквизита юзера
     */
    private String requisite;
    /**
     * баланс на счете
     */
    private double balance;

    /**
     * Конструктор для инициализации
     * @param requisite номер реквизита
     * @param balance баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод для получения реквизита аккаунта
     * @return номер реквизита
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод для изменения реквизита аккаунта
     * @param requisite значение которое
     *                  хотим подставить
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод для получения баланса аккаунта
     * @return возвращает значение баланса
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод для изменения баланса аккаунта
     * @param balance значение баланса которое
     *                хотим подставить
     */
    public void setBalance(double balance) {
        this.balance = balance;
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод для корректного определения хешкода
     * @return хэшкод
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
