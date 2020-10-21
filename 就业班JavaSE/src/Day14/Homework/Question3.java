package Day14.Homework;

public class Question3 {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        new Thread(() -> {
            while (true) {
                synchronized (o1) {
                    synchronized (o2) {
                        System.out.println("lalala正在执行");
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (o2) {
                    synchronized (o1) {
                        System.out.println("dududu正在执行");
                    }
                }
            }
        }).start();

    }
}

