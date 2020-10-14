package Day14.CodeReview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolReview2 {
    public static void main(String[] args) {
        /*
            阿里巴巴开发手册中，明确指出，禁止用此种方式创建线程池，
            会出现OutOfMemory错误，要求使用ThreadPoolExecutor创建线程池
         */

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + " is running"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + " is running"));
    }
}
