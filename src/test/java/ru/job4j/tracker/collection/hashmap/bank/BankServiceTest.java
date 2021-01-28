package ru.job4j.tracker.collection.hashmap.bank;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void findByPass() {
        User user = new User("3434", "Petr Arsentev");
        User user1 = new User("5252", "Gerbert Schmidt");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addUser(user1);
        Optional<User> expected = bank.findByPassport("3434");
        String name = "Petr Arsentev";
        assertThat(name, is(user.getUsername()));
    }

    @Test
    public void findByAcc() {
        User user = new User("3434", "Petr Arsentev");
        User user1 = new User("5252", "Gerbert Schmidt");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addUser(user1);
        bank.addAccount("3434", new Account("57897", 252));
        bank.addAccount("5252", new Account("77778", 5547));
        bank.findByRequisite("5252", "77778");
        Double expected = bank.findByRequisite("5252", "77778").get().getBalance();
        assertThat(expected, is(5547D));
    }

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434").get(), is(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertNull(bank.findByRequisite("34", "5546"));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150));
        assertThat(bank.findByRequisite("3434", "5546").get().getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").get().getBalance(), is(200D));
    }
}