package ru.job4j.banking;

import java.util.*;

public class Bank {
    private Map<User, ArrayList<Account>> database = new HashMap<>();

    public void addUser(User user) {
        this.database.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.database.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        getUserAccounts(passport).add(account);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        int index = getUserAccounts(passport).indexOf(account);
        if (index != -1) {
            getUserAccounts(passport).remove(index);
        }
    }

    public List<Account> getUserAccounts(String passport) {
        Optional<User> user =  this.database.keySet().stream().filter(e -> passport.equals(e.getPassport())).findFirst();
        return user.isPresent() ? this.database.get(user.get()) : new ArrayList<>();
    }

    public Account getAccount(String passport, String requisites) {
        return getUserAccounts(passport).stream().
                filter(e -> requisites.equals(e.getRequisites())).findFirst().orElse(null);
    }

    public boolean isUserExist(String passport) {
        return this.database.keySet().stream().anyMatch(e -> passport.equals(e.getPassport()));
    }

    public boolean transferMoney(String srcPassport, String srcRequisites,
                                 String destPassport, String destRequisites, double amount) {
        boolean result = false;
        Account source = getAccount(srcPassport, srcRequisites);
        Account destination = getAccount(destPassport, destRequisites);
        if (source != null && destination != null && source.getValue() - amount > 0) {
            source.setValue(source.getValue() - amount);
            destination.setValue(destination.getValue() + amount);
            result = true;
        }
        return result;
    }
}
