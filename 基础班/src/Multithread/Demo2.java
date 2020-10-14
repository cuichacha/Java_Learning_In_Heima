package Multithread;

public class Demo2 implements Runnable {
    private int withdraw = 100;

    @Override
    public void run() {
        go();
    }

    private synchronized void go() {
        for (int i = 0; i < 20; i++) {
            withdraw--;
            System.out.println(Thread.currentThread().getName() + "正在执行，余额" + withdraw);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Demo1 demo1_1 = new Demo1();
        Demo1 demo1_2 = new Demo1();
        Demo1 demo1_3 = new Demo1();

        Thread thread1 = new Thread(demo1_1, "取钱1");
        Thread thread2 = new Thread(demo1_2, "取钱2");
        Thread thread3 = new Thread(demo1_3, "取钱3");
        thread1.start();
        thread2.start();
    }
}

