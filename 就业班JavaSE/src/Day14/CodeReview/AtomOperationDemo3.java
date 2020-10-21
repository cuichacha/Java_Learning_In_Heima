package Day14.CodeReview;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomOperationDemo3 {
    public static void main(String[] args) {
        MyRunnable3 myRunnable3 = new MyRunnable3();

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            new Thread(myRunnable3).start();
        }
        long time2 = System.currentTimeMillis();
        System.out.println("Time is " + (time2 - time1));
    }
}

class MyRunnable3 implements Runnable {
    //    private volatile int count = 0;
    AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println(count.incrementAndGet());
        }
    }
}