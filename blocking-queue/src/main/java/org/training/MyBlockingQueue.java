package org.training;

import java.util.ArrayList;

public class MyBlockingQueue<E> {
    private int count;
    private final ArrayList<E> queue;

    public MyBlockingQueue(int count) {
        this.count = count;
        this.queue = new ArrayList<>(count);
    }

    public synchronized void enqueue(E e) throws InterruptedException {
        while (queue.size() == count) {
            wait();
        }
        if (queue.size() < count) {
            queue.add(e);
            count++;
            notify();
        }
    }

    public synchronized Object dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        count--;
        Object o = queue.remove(0);
        notify();
        return o;
    }

    public synchronized int size() {
        return queue.size();
    }
}
