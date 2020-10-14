package Day13.Code;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo3 {
    public static void main(String[] args) {
        MyCallable1 myCallable1 = new MyCallable1();
        FutureTask<String> futureTask = new FutureTask<>(myCallable1);
        Thread thread1 = new Thread(futureTask);
        Thread thread2 = new Thread(futureTask);
        thread1.start();
        thread2.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException exception) {
            exception.printStackTrace();
        }
    }
}

class MyCallable1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("啦啦" + i);
        }
        return "哈哈";
    }
}
