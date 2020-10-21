package Day13.Code;

public class ThreadDemo2 {
    public static void main(String[] args) {
        MyRunnable1 myRunnable1 = new MyRunnable1();

        Thread thread1 = new Thread(myRunnable1);
        Thread thread2 = new Thread(myRunnable1);

        thread1.start();
        thread2.start();
    }
}

class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("啦啦啦" + i);
        }
    }
}
