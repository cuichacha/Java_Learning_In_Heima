package Day13.Homework;

public class Question2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        Thread thread1 = new Thread(myThread2, "窗口一");
        Thread thread2 = new Thread(myThread2, "窗口二");
        Thread thread3 = new Thread(myThread2, "窗口三");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyThread2 implements Runnable {
    private int ticketNumber = 100;
    private int count = 0;

    @Override
    public void run() {
        while (ticketNumber > 0) {
            sellTickets();
        }
    }

    private synchronized void sellTickets() {
        count++;
        ticketNumber--;
        try {
            Thread.sleep(100);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        if (ticketNumber >= 0) {
            System.out.println(Thread.currentThread().getName() + "卖出第" + count +
                    "张票，还剩" + ticketNumber + "张票");
        }
    }
}
