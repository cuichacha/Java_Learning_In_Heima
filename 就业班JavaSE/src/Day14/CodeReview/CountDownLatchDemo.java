package Day14.CodeReview;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread1 thread1 = new Thread1(countDownLatch);
        Thread2 thread2 = new Thread2(countDownLatch);
        Thread3 thread3 = new Thread3(countDownLatch);
        Thread4 thread4 = new Thread4(countDownLatch);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

class Thread2 extends Thread {
    private CountDownLatch countDownLatch;

    public Thread2(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "--" +i);
        }
        countDownLatch.countDown();
    }
}

class Thread3 extends Thread {
    private CountDownLatch countDownLatch;

    public Thread3(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println(getName() + "--" +i);
        }
        countDownLatch.countDown();
    }
}

class Thread4 extends Thread {
    private CountDownLatch countDownLatch;

    public Thread4(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(getName() + "--" +i);
        }
        countDownLatch.countDown();
    }
}

class Thread1 extends Thread {
    private CountDownLatch countDownLatch;

    public Thread1(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println("等待结束");
    }
}