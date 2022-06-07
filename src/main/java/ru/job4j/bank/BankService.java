package ru.job4j.bank;

import java.util.*;
import java.util.stream.Stream;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод позволяет получить пользователя по паспорту
     * @return возвращает клиента с паспортом, которого находит в коллекции HashMap
     * либо возвращает null
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод позволяет получить номер счета, принадлежащий конкретному клиенту
     * @return возвращает номер счета клиента, которого находит в коллекции List<Account>
     * либо возвращает null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод позволяет получить данные счетов клинтов и если находит,
     * осуществляет перевод с одного счета клиента на другой счет этого или другого клиента
     * @return возвращает булевое значение перевода, где в случае успеха true
     * либо возвращает false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> from = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> to = findByRequisite(destPassport, destRequisite);
        if (from.isPresent() && to.isPresent() && from.get().getBalance() >= amount) {
            from.get().setBalance(from.get().getBalance() - amount);
            to.get().setBalance(to.get().getBalance() + amount);
            return true;
        }
        return rsl;
    }
}
