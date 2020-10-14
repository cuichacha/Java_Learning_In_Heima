package Day13.Homework;

public class Question1 {
    public static void main(String[] args) {
        Count count = new Count(100);

        MyThread1 myThread1 = new MyThread1(count);
        myThread1.start();
        while (count.getCount() > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            count.setCount(count.getCount() - 1);
            System.out.println(Thread.currentThread().getName() + "执行" + count.getCount());
        }
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

class MyThread1 extends Thread {
    Count count;

    public MyThread1(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (count.getCount() > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            count.setCount(count.getCount() - 1);
            System.out.println(getName() + "执行" + count.getCount());
        }
    }
}
