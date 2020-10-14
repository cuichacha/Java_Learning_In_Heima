package Day13.Code;

public class ThreadDemo8 {
    public static void main(String[] args) {
        MyThread3 thread1  = new MyThread3();
        MyThread4 thread2  = new MyThread4();
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
    }
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getId() + "-" + Thread.currentThread().getName() + "-" + i);
        }
    }
}

class MyThread4 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getId() + "-" + Thread.currentThread().getName() + "-" + i);
        }
    }
}