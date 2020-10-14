package Day14.CodeReview;

public class AtomOperationDemo2 {
    public static void main(String[] args) {
        MyRunnable2 myRunnable2 = new MyRunnable2();

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            new Thread(myRunnable2).start();
        }
        long time2 = System.currentTimeMillis();
        System.out.println("Time is " + (time2 - time1));
    }
}

class MyRunnable2 implements Runnable {
    private volatile int count = 0;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(++count);
            }
        }
    }
}