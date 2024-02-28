package org.training;

public class Consumer implements Runnable {
    private final MyBlockingQueue<Report> queue;

    public Consumer(MyBlockingQueue<Report> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Report report;
            while (!(report = (Report) queue.dequeue()).getString().equals("-")) {
                System.out.println("Consumer's report: " + report.getString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
