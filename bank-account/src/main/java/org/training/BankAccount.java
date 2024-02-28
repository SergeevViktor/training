package org.training;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private long id;
    private double account;
    private final Lock lock;

    public BankAccount(double amount) {
        this.account = amount;
        this.lock = new ReentrantLock();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public void deposit(double amount) {
        lock.lock();

        try {
            account += amount;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();

        try {
            if (account >= amount) {
                account -= amount;
            } else {
                System.out.println("Недостаточно средств");
            }
        } finally {
            lock.unlock();
        }
    }
}
