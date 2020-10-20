package Day14.Code;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo3 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1, 2, 2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threadPoolExecutor.submit(() -> System.out.println(Thread.currentThread().getId() + "--" +
                    Thread.currentThread().getName() + "--" + finalI));
        }

        threadPoolExecutor.shutdown();
    }
}
