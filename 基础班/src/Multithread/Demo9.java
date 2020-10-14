package Multithread;

public class Demo9 implements Runnable {
    private int withdraw = 100;

    @Override
    public void run() {
        go();
    }

    private void go() {
        synchronized (Demo9.class) {
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
    }

    public static void main(String[] args) {
        Demo9 demo9_1 = new Demo9();
        Demo9 demo9_2 = new Demo9();
        Demo9 demo9_3 = new Demo9();
        Thread thread1 = new Thread(demo9_1, "取钱1");
        Thread thread2 = new Thread(demo9_2, "取钱2");
        Thread thread3 = new Thread(demo9_3, "取钱3");
        thread1.start();
        thread3.start();
        thread2.start();


    }
}

