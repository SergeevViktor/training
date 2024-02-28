package org.training;

public class Producer implements Runnable {
    private final MyBlockingQueue<Report> queue;

    public Producer(MyBlockingQueue<Report> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            Report report = new Report(String.valueOf(i + 1));
            try {
                Thread.sleep(10);
                queue.enqueue(report);
                System.out.println("Producer's report: " + report.getString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Report msg = new Report("-");
        try {
            queue.enqueue(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
