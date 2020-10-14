package Day13.Code;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo12 {
    public static void main(String[] args) {
        MyRunnable7 myRunnable = new MyRunnable7();
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        thread1.start();
        thread2.start();
    }
}

class MyRunnable7 implements Runnable {
    private int ticket = 100;
    private ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                reentrantLock.lock();
                if (ticket <= 0) {
                    break;
                } else {
                    Thread.sleep(10);
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "卖出一张票，还剩" + ticket + "张票");
                }
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
