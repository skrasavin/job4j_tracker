package ru.job4j.tracker.collection.hashmap.bank;

import java.util.*;

/**
 * @author sskrasavin
 * @version 1.0
 */
public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * добавление пользователя в список банковского сервиса
     * @param user - кого добавляем
     */
    public void addUser(User user) {
        ArrayList<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    /**
     * добавить аккаунт по паспорту
     * @param passport - поиск по нему
     * @param account - аккаунт, который добавляется
     */
    public void addAccount(String passport, Account account) {
        if (findByPassport(passport) != null) {
            User user = findByPassport(passport);
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * найти пользователя по паспорту
     * @param passport - чтобы найти пользователя
     * @return - юзера
     */
    public User findByPassport(String passport) {
                return users.keySet().stream().filter(
                        user -> user.getPassport().equals(passport)
                ).findAny().orElse(null);
    }

    /**
     * найти счёт по реквизитам
     * @param passport - используется для поиска
     * @param requisite - тоже
     * @return - нужный счёт
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        return users.get(user).stream().filter(
          account -> account.getRequisite().equals(requisite)
        ).findAny().orElse(null);
    }

    /**
     * перевод средств на другой счёт
     * @param srcPassport - паспорт отправителя
     * @param srcRequisite - реквизиты отправителя
     * @param destPassport - паспорт получателя
     * @param destRequisite - реквизиты получателя
     * @param amount - сколько нужно перевести
     * @return True если ок
     */
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