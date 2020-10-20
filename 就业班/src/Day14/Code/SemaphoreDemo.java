package Day14.Code;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
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
            System.out.println("获得");
            Thread.sleep(200);
            System.out.println("归还");
            semaphore.release();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}