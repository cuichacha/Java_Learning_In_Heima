package Multithread;

public class Demo3 implements Runnable {
    private int withdraw = 100;

    @Override
    public void run() {
        go();
    }

    private void go() {
        for (int i = 0; i < 20; i++) {
            withdraw--;
            System.out.println(Thread.currentThread().getName() + "正在执行，余额" + withdraw);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Demo3 demo3_1 = new Demo3();
        Thread thread1 = new Thread(demo3_1, "取钱1");
        Thread thread2 = new Thread(demo3_1, "取钱2");
        Thread thread3 = new Thread(demo3_1, "取钱3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

