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
        List<Account> result = new ArrayList<>();
        for (User user : this.database.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = this.database.get(user);
                break;
            }
        }
        return result;
    }

    public Account getAccount(String passport, String requisites) {
        Account result = null;
        for (Account current : getUserAccounts(passport)) {
            if (current.getRequisites().equals(requisites)) {
                result = current;
                break;
            }
        }
        return result;
    }

    public boolean isUserExist(String passport) {
        boolean result = false;
        for (User user : this.database.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = true;
                break;
            }
        }
        return  result;
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
