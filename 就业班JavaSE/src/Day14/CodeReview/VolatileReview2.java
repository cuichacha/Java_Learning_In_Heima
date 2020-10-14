package Day14.CodeReview;

public class VolatileReview2 {
    public static void main(String[] args) {
        new Person3().start();
        new Person4().start();
    }
}

class Money2 {
    private volatile static int money = 100;

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        Money2.money = money;
    }
}

class Person3 extends Thread {
    @Override
    public void run() {
        while (Money2.getMoney() == 100) {

        }
        System.out.println("!!!");
    }
}

class Person4 extends Thread{
    @Override
    public void run() {
        try {
            sleep(100);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        Money2.setMoney(99);
    }
}