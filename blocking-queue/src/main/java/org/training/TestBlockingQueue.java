package org.training;

public class TestBlockingQueue {
    public static void main(String[] args) {
        MyBlockingQueue<Report> queue = new MyBlockingQueue<>(2);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}