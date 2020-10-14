package Day14.CodeReview;

import java.util.concurrent.Semaphore;

public class SemaphoreReview {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        for (int i = 0; i < 100; i++) {
            new Thread(myRunnable).start();
        }
    }
}

class MyRunnable implements Runnable {
    Semaphore semaphore = new Semaphore(2);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("开始执行");
            Thread.sleep(1000);
            System.out.println("执行结束");
            semaphore.release();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}