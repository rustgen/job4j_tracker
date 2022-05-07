package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        if (!users.containsKey(user)) {
            users.put(user, accounts);
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        if (!accounts.contains(account)) {
            accounts.add(account);
            users.put(user, accounts);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().contains(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        if (user != null && accounts.contains(requisite)) {
           return accounts.get(Integer.parseInt(requisite));
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        User user = findByPassport(srcPassport);
        List<Account> accounts = users.get(user);
        if (accounts.contains(findByRequisite(srcRequisite, srcRequisite))
                && accounts.contains(findByRequisite(destPassport, destRequisite))) {

        }
        return rsl;
    }
}
