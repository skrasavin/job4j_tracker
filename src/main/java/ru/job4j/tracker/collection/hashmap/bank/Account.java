package ru.job4j.tracker.collection.hashmap.bank;

import java.util.Objects;

/**
 * Account
 */
public class Account {
    private String requisite;
    private double balance;

    /**
     * Account
     * @param requisite test
     * @param balance test
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * getRequisite
     * @return requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * setRequisite
     * @param requisite test
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}