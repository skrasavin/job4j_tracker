package ru.job4j.tracker.collection.hashset.bank;

import java.util.HashSet;
import java.util.List;

/**
 * NotifyAccount
 */
public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        return new HashSet<>(accounts);
    }
}