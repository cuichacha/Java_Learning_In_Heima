package Day14.Code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId() + "--" +
                        Thread.currentThread().getName() + "--" + "啦啦-1");

            }
        });

        executorService.submit(() -> System.out.println(Thread.currentThread().getId() +
                "--" + Thread.currentThread().getName() + "--" + "嘟嘟-1"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        executorService.submit(() -> System.out.println(Thread.currentThread().getId() +
                "--" + Thread.currentThread().getName() + "--" + "滴滴-1"));

        executorService.shutdown();

    }
}
