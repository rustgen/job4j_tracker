package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает перевод стредств с одного
 * банковского счета на другой
 * @author Rust
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение задания осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет объект user в Map
     * и создает пустой список аккаунтов коллекции List<Account>
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод ищет пользователя по паспорту и если не находит, то
     * добавляет в List<Account> новый счет и присваивает его пользователю,
     * если такового не имеется
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспорту
     * @return возвращает клиента с паспортом, которого находит в коллекции HashMap
     * либо возвращает null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет номер счета, принадлежащий конкретному клиенту
     * @return возвращает номер счета клиента, которого находит в коллекции List<Account>
     * либо возвращает null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account num : accounts) {
                if (num.getRequisite().equals(requisite)) {
                    return num;
                }
            }
        }
        return null;
    }

    /**
     * Метод осуществляет перевод с одного счета клиента на другой счет этого или другого клиента
     * @return возвращает булевое значение перевода, где в случае успеха true
     * либо возвращает false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account from = findByRequisite(srcPassport, srcRequisite);
        Account to = findByRequisite(destPassport, destRequisite);
        if (from != null && to != null && from.getBalance() >= amount) {
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
            return true;
        }
        return rsl;
    }
}
