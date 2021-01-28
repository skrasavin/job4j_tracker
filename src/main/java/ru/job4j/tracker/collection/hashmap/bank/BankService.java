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
            Optional<User> user = findByPassport(passport);
            if (user.isPresent()) {
                List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        for (var user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = Optional.of(user);
                break;
            }
        }
        return rsl;
    }

    /**
     * найти счёт по реквизитам
     * @param passport - используется для поиска
     * @param requisite - тоже
     * @return - нужный счёт
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            for (var acoount : users.get(user.get())) {
                if (acoount.getRequisite().equals(requisite)) {
                    return Optional.of(acoount);
                }
            }
//            return users.get(user).stream().filter(
//                    account -> account.getRequisite().equals(requisite)
//            ).findAny().orElse(null);
        }
        return Optional.empty();
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null) {
            if (srcAccount.get().getBalance() - amount < 0) {
                return false;
            }
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
        }
        return true;
    }
}