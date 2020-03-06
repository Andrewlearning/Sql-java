package JavaPractice.AbcPrintTenTimes;
import java.util.TreeSet;
import java.util.concurrent.locks.*;

public class AbcLock{
    private static Lock lock = new ReentrantLock();// 通过JDK5中的Lock锁来保证线程的访问的互斥
    private static int state = 0;//通过state的值来确定是否打印

    static class ThreadA extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10;){
                try {
                    lock.lock();
                    while (state%3 == 0){
                        System.out.println("A");
                        state++;
                        i++;
                    }
                }finally{
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10;){
                try {
                    lock.lock();
                    while (state%3 == 1){
                        System.out.println("B");
                        state++;
                        i++;
                    }
                }finally{
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadC extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10;){
                try {
                    lock.lock();
                    while (state%3 == 2){
                        System.out.println("C");
                        state++;
                        i++;
                    }
                }finally{
                    lock.unlock();
                }
            }
        }
    }


    public static void main(final String[] args) {
        // new ThreadA().start();
        // new ThreadB().start();
        // new ThreadC().start();
        final AbcLock abclock = new AbcLock();
        System.out.println(abclock.toString());
    }


}

