package ru.job4j.tracker.collection.hashMap.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        ArrayList<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        ArrayList<Account> accounts = (ArrayList<Account>) users.get(user);
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    //найти счёт по реквизитам
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        ArrayList<Account> accounts = (ArrayList<Account>) users.get(user);
        for (Account account : accounts) {
            if (account.getRequisite().equals(requisite)) {
                return account;
            }
        }

        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.getBalance() - amount < 0) {
            return false;
        }
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        return true;
    }
}