package Day13.Code;

public class ThreadDemo6 {
    public static void main(String[] args) {
        MyRunnable3 myRunnable = new MyRunnable3();
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        thread1.start();
        thread2.start();
    }
}

class MyRunnable3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId() + "-" + Thread.currentThread().getName() + "-" + i);
        }
    }
}
