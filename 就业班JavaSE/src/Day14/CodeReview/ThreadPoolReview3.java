package Day14.CodeReview;

import java.util.concurrent.*;

public class ThreadPoolReview3 {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                3, 100, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        threadPoolExecutor.submit(() -> System.out.println(Thread.currentThread().getName() + " is running"));
        threadPoolExecutor.shutdown();
    }
}
