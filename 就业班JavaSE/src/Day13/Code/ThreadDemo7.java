package Day13.Code;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadDemo7 {
    public static void main(String[] args) {
        MyCallable2 callable1 = new MyCallable2();
        MyCallable2 callable2 = new MyCallable2();
        FutureTask<String> futureTask1 = new FutureTask<>(callable1);
        FutureTask<String> futureTask2 = new FutureTask<>(callable2);
        Thread thread1 = new Thread(futureTask1);
        Thread thread2 = new Thread(futureTask2);
        thread1.setPriority(1);
        thread2.setPriority(10);
        thread1.start();
        thread2.start();
    }
}

class MyCallable2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getId() + "-" + Thread.currentThread().getName() + "-" + i);
        }
        return "啦啦";
    }
}
