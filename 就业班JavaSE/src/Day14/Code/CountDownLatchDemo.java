package Day14.Code;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        MyThread1 myThread1 = new MyThread1(countDownLatch);
        MyThread2 myThread2 = new MyThread2(countDownLatch);
        MyThread3 myThread3 = new MyThread3(countDownLatch);

        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}

class MyThread1 extends Thread {
    private CountDownLatch countDownLatch;

    public MyThread1(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println("等待结束，进行执行");
    }
}

class MyThread2 extends Thread {
    private CountDownLatch countDownLatch;

    public MyThread2(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
        }
        countDownLatch.countDown();
    }
}

class MyThread3 extends Thread {
    private CountDownLatch countDownLatch;

    public MyThread3(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
        }
        countDownLatch.countDown();
    }
}