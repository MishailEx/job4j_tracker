package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

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

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

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
