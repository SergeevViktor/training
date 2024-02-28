package org.training;

import java.util.concurrent.*;

public class ComplexTaskExecutor {
    private final CyclicBarrier cyclicBarrier;
    private final ExecutorService executorService;
    private final ComplexTask complexTask;

    public ComplexTaskExecutor(int value) {
        this.cyclicBarrier = new CyclicBarrier(value);
        this.executorService = Executors.newFixedThreadPool(value);
        this.complexTask = new ComplexTask();
    }

    public void executeTasks(int numberOfTasks) {
        for (int i = 0; i < numberOfTasks; i++) {
            executorService.submit(() -> {
                complexTask.execute();

                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
    }
}
