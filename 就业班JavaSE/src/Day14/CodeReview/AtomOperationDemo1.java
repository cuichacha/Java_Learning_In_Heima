package Day14.CodeReview;

public class AtomOperationDemo1 {
    public static void main(String[] args) {
        MyRunnable1 myRunnable1 = new MyRunnable1();

        for (int i = 0; i < 100; i++) {
            new Thread(myRunnable1).start();
        }
    }
}

class MyRunnable1 implements Runnable {
    private volatile int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(++count);
        }
    }
}