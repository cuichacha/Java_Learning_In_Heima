package Day13.CodeReview;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueReview {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        Count count = new Count(50);
        MyThread9 myThread9 = new MyThread9(arrayBlockingQueue, count, "生产者");
        MyThread10 myThread10 = new MyThread10(arrayBlockingQueue, count, "消费者");
        myThread9.start();
        myThread10.start();
    }
}

class Count {
    private int count;

    public Count(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

class MyThread9 extends Thread {
    private ArrayBlockingQueue<String> arrayBlockingQueue;
    private Count count;

    public MyThread9(ArrayBlockingQueue<String> arrayBlockingQueue, Count count, String name) {
        super(name);
        this.arrayBlockingQueue = arrayBlockingQueue;
        this.count = count;
    }

    @Override
    public void run() {
        while (count.getCount() >= 0) {
            try {
                arrayBlockingQueue.put("商品");
                System.out.println(getName() + "生产了一个商品" + count.getCount());
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}

class MyThread10 extends Thread {
    private ArrayBlockingQueue<String> arrayBlockingQueue;
    private Count count;

    public MyThread10(ArrayBlockingQueue<String> arrayBlockingQueue, Count count, String name) {
        super(name);
        this.arrayBlockingQueue = arrayBlockingQueue;
        this.count = count;
    }

    @Override
    public void run() {
        while (count.getCount() >= 0) {
            try {
                arrayBlockingQueue.take();
                System.out.println(getName() + "消耗了一个商品" + count.getCount());
                count.setCount(count.getCount() - 1);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}