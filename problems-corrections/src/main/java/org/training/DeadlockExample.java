package org.training;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    private static class Resource {
        // Ресурсы
    }

    private final Resource resourceA = new Resource();
    private final Resource resourceB = new Resource();
    private final Lock lockA = new ReentrantLock();
    private final Lock lockB = new ReentrantLock();

    public void execute() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                acquireResourcesAndWork(lockA, lockB, resourceA, resourceB, "Thread-1");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                acquireResourcesAndWork(lockB, lockA, resourceB, resourceA, "Thread-2");
            }
        });

        thread1.start();
        thread2.start();
    }

    private void acquireResourcesAndWork(Lock firstLock, Lock secondLock,
                                         Resource firstResource, Resource secondResource,
                                         String threadName) {
        while (true) {
            //firstLock.lock();
            boolean fl = firstLock.tryLock();
            boolean sl = false;
            //System.out.println(threadName + " locked " + firstResource);

            if (fl) {
                try {
                    System.out.println(threadName + " locked " + firstResource);
                    // Имитация работы с ресурсом
                    Thread.sleep(100);

                    //secondLock.lock();
                    sl = secondLock.tryLock();
                    //System.out.println(threadName + " locked " + secondResource);

                    if (sl) {
                        try {
                            System.out.println(threadName + " locked " + secondResource);
                            // Имитация работы с ресурсом
                            Thread.sleep(100);
                        /*} catch (InterruptedException e) {
                              Thread.currentThread().interrupt();*/
                        } finally {
                            secondLock.unlock();
                            System.out.println(threadName + " unlocked " + secondResource);
                        }
                    }
                } catch (InterruptedException e) {
                    //Thread.currentThread().interrupt();
                    e.getStackTrace();
                } finally {
                    firstLock.unlock();
                    System.out.println(threadName + " unlocked " + firstResource);
                }
            }

            if (fl && sl) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        DeadlockExample example = new DeadlockExample();
        example.execute();
    }
}
