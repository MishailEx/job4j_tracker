package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывающий управление пользователями и их аккаунтами
 * @author Michail
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей и их аккаунтов осуществляется в коллекции типа Map
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяющий добаить пользователя и его список аккаунтов,
     * если его там нет
     * @param user принимает на вход пользователя
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добаляет аккаунт пользователю если пльзователь найден
     * и у него такого аккаунта нет
     * @param passport принимает паспорт, по которому найдет пользователя
     * @param account принимает аккаунт который необходимо добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (users.get(user).contains(account)) {
                System.out.println("Аккаунт уже существует");
            }
            users.get(user).add(account);
        }
        System.out.println("User с таким паспортом не существует");
    }

    /**
     * Метод позволяющий найти пользователя в коллекции
     * @param passport принимает паспорт для поиска пользователя
     * @return найденного пользователя
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ползволяет найти аккаунт пользователя
     * @param passport принимает паспорт по которому будет найден пользователь
     * @param requisite принимает реквизит который будут искать в саиске аккаунтов
     * @return возвращает найденный аккаунт
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(e -> e.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод позволяющий преводить деньги с одного аккаунта на другой
     * @param srcPassport принимает значение паспорта пользователя который хочет перевести деньги
     * @param srcRequisite принимает реквизит пользователя который хочет перевести деньги
     * @param destPassport принимает значение паспорта пользователя которому хотят перевести деньги
     * @param destRequisite принимает реквизит пользователя которому хотят перевести деньги
     * @param amount принимает сумму перевода
     * @return возвращает успешно прошла операция или нет
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account account = findByRequisite(srcPassport, srcRequisite);
        Account account1 = findByRequisite(destPassport, destRequisite);
        if (account != null && account1 != null) {
            if (account.getBalance() >= amount) {
                account1.setBalance(account1.getBalance() + amount);
                account.setBalance(account.getBalance() - amount);
                rsl = true;
            }
        }
        return rsl;
    }
}
