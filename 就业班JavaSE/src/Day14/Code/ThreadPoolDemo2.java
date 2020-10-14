package Day14.Code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId() + "--" +
                        Thread.currentThread().getName() + "--" + "啦啦-2");

            }
        });

        executorService.submit(() -> System.out.println(Thread.currentThread().getId() +
                "--" + Thread.currentThread().getName() + "--" + "嘟嘟-2"));
        executorService.submit(() -> System.out.println(Thread.currentThread().getId() +
                "--" + Thread.currentThread().getName() + "--" + "嘟嘟-2"));
        executorService.submit(() -> System.out.println(Thread.currentThread().getId() +
                "--" + Thread.currentThread().getName() + "--" + "嘟嘟-2"));
        executorService.submit(() -> System.out.println(Thread.currentThread().getId() +
                "--" + Thread.currentThread().getName() + "--" + "嘟嘟-2"));

        executorService.shutdown();
    }
}
