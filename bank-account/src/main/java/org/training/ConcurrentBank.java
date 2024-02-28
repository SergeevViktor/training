package org.training;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentBank {
    private final ConcurrentMap<Long, BankAccount> accounts = new ConcurrentHashMap<>();
    private static long id = 1L;
    private final Object monitor = new Object();

    public synchronized BankAccount createAccount(double amount) {
        BankAccount bankAccount = new BankAccount(amount);
        bankAccount.setId(id++);
        accounts.put(id, bankAccount);

        return bankAccount;
    }

    public void transfer(BankAccount sender, BankAccount recipient, double amount) {
        synchronized (monitor) {
            if (sender != null && recipient != null
                    && amount > 0 && sender.getAccount() >= amount ) {
                sender.withdraw(amount);
                recipient.deposit(amount);
                System.out.printf("Перевод: сумма - %f, отправитель %d, получать %d%n",
                        amount, sender.getId(), recipient.getId());
            } else {
                System.out.println("Перевод отменен");
            }
        }
    }

    public double getTotalBalance() {
        double total = 0;

        for (BankAccount account : accounts.values()) {
            total += account.getAccount();
        }

        return total;
    }
}
