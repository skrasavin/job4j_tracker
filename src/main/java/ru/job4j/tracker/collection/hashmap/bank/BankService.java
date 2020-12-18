package ru.job4j.tracker.collection.hashmap.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        ArrayList<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    public void addAccount(String passport, Account account) {
        if (findByPassport(passport) != null) {
            User user = findByPassport(passport);
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    //найти пользователя по паспорту
    public User findByPassport(String passport) {
                return users.keySet().stream().filter(
                        user -> user.getPassport().equals(passport)
                ).findAny().orElse(null);
    }

    //найти счёт по реквизитам
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        return users.get(user).stream().filter(
          account -> account.getRequisite().equals(requisite)
        ).findAny().orElse(null);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null) {
            if (srcAccount.getBalance() - amount < 0) {
                return false;
            }
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
        }
        return true;
    }
}