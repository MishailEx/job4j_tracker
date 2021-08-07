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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            if (!users.get(user.get()).contains(account)) {
                users.get(user.get()).add(account);
            } else {
                System.out.println("Аккаунт уже существует");
            }
        } else {
            System.out.println("User с таким паспортом не существует");
        }
    }

    /**
     * Метод позволяющий найти пользователя в коллекции
     * @param passport принимает паспорт для поиска пользователя
     * @return найденного пользователя
     */
    public  Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ползволяет найти аккаунт пользователя
     * @param passport принимает паспорт по которому будет найден пользователь
     * @param requisite принимает реквизит который будут искать в саиске аккаунтов
     * @return возвращает найденный аккаунт
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(e -> e.getRequisite().equals(requisite))
                .findFirst());
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
        Optional<Account> account = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> account1 = findByRequisite(destPassport, destRequisite);
        if (account.isPresent() && account1.isPresent()) {
            if (account.get().getBalance() >= amount) {
                account1.get().setBalance(account1.get().getBalance() + amount);
                account.get().setBalance(account.get().getBalance() - amount);
                rsl = true;
            }
        }
        return rsl;
    }
}
