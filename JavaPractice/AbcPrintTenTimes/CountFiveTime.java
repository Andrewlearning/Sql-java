package JavaPractice.AbcPrintTenTimes;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * CountFiveTime
 */
public class CountFiveTime {

    private static Lock lock = new ReentrantLock();
    private static volatile int state = 0;

    public static class ThreadA extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 5;) {
                try {
                    lock.lock();
                    while (state % 2 == 0) {
                        System.out.println(currentThread().getName() + " " + i);
                        state++;
                        i++;
                    }

                } finally {
                    lock.unlock();
                }
            }
        }

    }

    public static class ThreadB extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 5;) {
                try {
                    lock.lock();
                    while (state % 2 == 1) {
                        System.out.println(currentThread().getName() + " " + i);
                        state++;
                        i++;
                    }

                } finally {
                    lock.unlock();
                }
            }
        }

    }

    public static void main(final String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadB.start();
    }
    
}