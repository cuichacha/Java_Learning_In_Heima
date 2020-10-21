package Day13.CodeReview;

public class MultiThreadsReview2 {
    public static void main(String[] args) {
        MyThread4 myThread4 = new MyThread4();
        Thread thread1 = new Thread(myThread4, "窗口一");
        Thread thread2 = new Thread(myThread4, "窗口二");
        Thread thread3 = new Thread(myThread4, "窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyThread4 implements Runnable {
    private int ticketNumber = 100;
    private int count = 0;

    @Override
    public void run() {
        while (ticketNumber > 0) {
            try {
                sellTickets();
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

    private synchronized void sellTickets() {
        count++;
        ticketNumber--;
        if (ticketNumber >= 0) {
            System.out.println(Thread.currentThread().getName() + "卖出第" + count +
                    "张票，剩余" + ticketNumber + "张票");
        }
    }
}
