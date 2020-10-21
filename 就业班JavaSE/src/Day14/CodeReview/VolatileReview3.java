package Day14.CodeReview;

public class VolatileReview3 {
    public static void main(String[] args) {
        new Person5().start();
        new Person6().start();
    }
}

class Money3 {
    private static int money = 100;

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        Money3.money = money;
    }
}

class Person5 extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Money3.class) {
                if (Money3.getMoney() != 100) {
                    System.out.println("!!!");
                    break;
                }
            }
        }
    }
}

class Person6 extends Thread {
    @Override
    public void run() {
        synchronized (Money3.class) {
            try {
                sleep(10);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            Money3.setMoney(99);
        }
    }
}