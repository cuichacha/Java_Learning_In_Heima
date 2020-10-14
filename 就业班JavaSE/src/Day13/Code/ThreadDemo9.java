package Day13.Code;

public class ThreadDemo9 {
    public static void main(String[] args) {
        MyRunnable4 myRunnable = new MyRunnable4();
        Thread thread1 = new Thread(myRunnable, "窗口一");
        Thread thread2 = new Thread(myRunnable, "窗口二");
        Thread thread3 = new Thread(myRunnable, "窗口三");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyRunnable4 implements Runnable {
    private int tickets = 100;

    @Override
    public void run() {
        if (tickets >= 0) {
            go();
        }
    }

    public synchronized void go() {
        for (int i = 1; i <= tickets; i++) {
            tickets--;
            System.out.println(Thread.currentThread().getName() + "卖出第" + i + "张票");
        }
    }
}