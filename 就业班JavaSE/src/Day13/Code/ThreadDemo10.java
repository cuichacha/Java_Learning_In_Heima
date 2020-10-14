package Day13.Code;

public class ThreadDemo10 {
    public static void main(String[] args) {
        MyRunnable5 myRunnable = new MyRunnable5();
        Thread thread1 = new Thread(myRunnable, "窗口一");
        Thread thread2 = new Thread(myRunnable, "窗口二");
        Thread thread3 = new Thread(myRunnable, "窗口三");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyRunnable5 implements Runnable {
    private int tickets = 100;

    @Override
    public void run() {
        while (tickets > 0) {
            synchronized (this) {
                tickets--;
            }
            System.out.println(Thread.currentThread().getName() + "卖出一张票，还剩" + tickets + "张票");
        }
    }
}