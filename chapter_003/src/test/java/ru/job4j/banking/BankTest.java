package ru.job4j.banking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class BankTest {
    private User alex = new User("Alex", "A3742E");
    private User viktor = new User("Viktor", "B3237R");

    @Test
    public void whenAddUserThenUserExistTrue() {
        Bank bank = new Bank();
        bank.addUser(alex);
        boolean result = bank.isUserExist(alex.getPassport());
        assertThat(result, is(true));
    }

    @Test
    public void whenDeleteUserThenUserExistFalse() {
        Bank bank = new Bank();
        bank.addUser(alex);
        bank.deleteUser(alex);
        boolean result = bank.isUserExist(alex.getPassport());
        assertThat(result, is(false));
    }

    @Test
    public void whenAddAccountToUserThenUserHasNewAccount() {
        Bank bank = new Bank();
        Account account = new Account(10, "ABC123");
        bank.addUser(alex);
        bank.addAccountToUser(alex.getPassport(), account);
        List<Account> result = bank.getUserAccounts(alex.getPassport());
        assertThat(result.get(0), is(account));
    }

    @Test
    public void whenDeleteAccountFromUserThenUserNotHaveThisAccount() {
        Bank bank = new Bank();
        Account account = new Account(15, "ABC123");
        bank.addUser(alex);
        bank.addAccountToUser(alex.getPassport(), account);
        bank.deleteAccountFromUser(alex.getPassport(), account);
        Account result = bank.getAccount(alex.getPassport(), "ABC123");
        assertThat(result, is((Account) null));
    }


    @Test
    public void whenGetUserAccounts() {
        Bank bank = new Bank();
        Account first= new Account(15, "ABC123");
        Account second= new Account(25, "DEF456");
        bank.addUser(alex);
        bank.addAccountToUser(alex.getPassport(), first);
        bank.addAccountToUser(alex.getPassport(), second);
        List<Account> result = bank.getUserAccounts(alex.getPassport());
        assertThat(result.toArray(), is(new Account[] {first, second}));
    }

    @Test
    public void whenGetAccountByRequisites() {
        Bank bank = new Bank();
        Account first = new Account(15, "ABC123");
        Account second= new Account(25, "DEF456");
        bank.addUser(alex);
        bank.addAccountToUser(alex.getPassport(), first);
        bank.addAccountToUser(alex.getPassport(), second);
        Account result = bank.getAccount(alex.getPassport(), "DEF456");
        assertThat(result, is(second));

    }

    @Test
    public void whenAccountsExistsAndSourceAccountHasMoneyThenTransferMoneyReturnTrue() {
        Bank bank = new Bank();
        bank.addUser(alex);
        bank.addAccountToUser(alex.getPassport(), new Account(100, "123456"));
        bank.addUser(viktor);
        bank.addAccountToUser(viktor.getPassport(), new Account(0, "7891011"));
        boolean result = bank.transferMoney(alex.getPassport(), "123456",
                viktor.getPassport(), "7891011", 50);
        assertThat(result, is(true));
    }

    @Test
    public void whenSourceAccountNotHasMoneyThenTransferMoneyReturnFalse() {
        Bank bank = new Bank();
        bank.addUser(alex);
        bank.addAccountToUser(alex.getPassport(), new Account(30, "123456"));
        bank.addUser(viktor);
        bank.addAccountToUser(viktor.getPassport(), new Account(0, "7891011"));
        boolean result = bank.transferMoney(alex.getPassport(), "123456",
                viktor.getPassport(), "7891011", 50);
        assertThat(result, is(false));
    }
}
