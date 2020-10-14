package Day13.Code;

public class ThreadDemo5 {
    public static void main(String[] args) {
        MyRunnable2 myRunnable = new MyRunnable2();
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        thread1.start();
        thread2.start();
    }
}

class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getId() + "-" + Thread.currentThread().getName() + "-" + i);
        }
    }
}