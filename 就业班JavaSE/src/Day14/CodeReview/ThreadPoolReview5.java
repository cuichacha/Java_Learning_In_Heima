package Day14.CodeReview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolReview5 {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                3, 100, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < 12; i++) {
            int finalI = i;
            threadPoolExecutor.submit(() -> System.out.println(Thread.currentThread().getName() + " is running --- " + finalI));
        }
        threadPoolExecutor.shutdown();
    }
}
