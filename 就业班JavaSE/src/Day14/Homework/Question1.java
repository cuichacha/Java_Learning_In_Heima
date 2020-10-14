package Day14.Homework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Question1 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(1), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        MyRunnable1 myRunnable1 = new MyRunnable1();
        threadPoolExecutor.submit(myRunnable1);
        threadPoolExecutor.shutdown();
    }
}

class MyRunnable1 implements Runnable {

    int count;
    @Override
    public void run() {
        while (count <= 10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.now();
            System.out.println(localDateTime.format(pattern));
            count++;
        }
    }
}
