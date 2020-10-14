package Day14.CodeReview;

public class VolatileReview1 {
    public static void main(String[] args) {
        new Person1().start();
        new Person2().start();
    }
}

class Money1 {
    private static int money = 100;

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        Money1.money = money;
    }
}

class Person1 extends Thread {
    @Override
    public void run() {
        while (Money1.getMoney() == 100) {

        }
        System.out.println("!!!");
    }
}

class Person2 extends Thread{
    @Override
    public void run() {
        try {
            sleep(100);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        Money1.setMoney(99);
    }
}