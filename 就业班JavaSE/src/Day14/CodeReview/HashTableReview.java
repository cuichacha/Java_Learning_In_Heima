package Day14.CodeReview;

import java.util.Hashtable;

public class HashTableReview {
    public static void main(String[] args) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                hashtable.put(i, i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 50; i < 100; i++) {
                hashtable.put(i, i);
            }
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(hashtable.get(i));
        }
    }
}
