package Day14.CodeReview;

import java.util.HashMap;

public class HashMapReview {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                hashMap.put(i, i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 20; i < 40; i++) {
                hashMap.put(i, i);
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 40; i < 60; i++) {
                hashMap.put(i, i);
            }
        });

        Thread thread4 = new Thread(() -> {
            for (int i = 60; i < 80; i++) {
                hashMap.put(i, i);
            }
        });

        Thread thread5 = new Thread(() -> {
            for (int i = 80; i < 100; i++) {
                hashMap.put(i, i);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(hashMap.get(i));
        }
    }
}
