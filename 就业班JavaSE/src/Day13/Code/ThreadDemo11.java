package Day13.Code;

public class ThreadDemo11 {
    public static void main(String[] args) {
        MyRunnable6 myRunnable = new MyRunnable6();
        Thread thread1 = new Thread(myRunnable, "窗口一");
        Thread thread2 = new Thread(myRunnable, "窗口二");
        Thread thread3 = new Thread(myRunnable, "窗口三");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyRunnable6 implements Runnable {
    private int tickets = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (tickets <= 0) {
                    break;
                } else {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                    tickets--;
                    System.out.println(Thread.currentThread().getName() + "卖出一张票，还剩" + tickets + "张票");
                }
            }
        }
    }
}