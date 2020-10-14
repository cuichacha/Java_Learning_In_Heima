package Day13.CodeReview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MultiThreadsReview1 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1("lala");

        myThread1.start();
        MyThread2 myThread2 = new MyThread2();
        new Thread(myThread2).start();
        MyThread3 myThread3 = new MyThread3();
        FutureTask<String> futureTask = new FutureTask<>(myThread3);
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException exception) {
            exception.printStackTrace();
        }

//        new FutureTask<String>(new Callable<String>(){
//            @Override
//            public String call() throws Exception {
//                return "";
//            }
//        });

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("lalala");
//            }
//        }).start();

//        new Thread(() -> System.out.println("lala")).start();

//        new FutureTask<String>(() -> {
//            System.out.println(" ");
//            return " ";
//        });
    }
}

class MyThread1 extends Thread {
    public MyThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getId() + "--" + Thread.currentThread().getName() + "--" + i);
        }
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getId() + "--" + Thread.currentThread().getName() + "--" + i);
        }
    }
}

class MyThread3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getId() + "--" + Thread.currentThread().getName() + "--" + i);
        }
        return "结束";
    }

}
