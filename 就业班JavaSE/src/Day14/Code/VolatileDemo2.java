package Day14.Code;

public class VolatileDemo2 {
    public static void main(String[] args) {
        Person3 person1 = new Person3();
        Person4 person2 = new Person4();
        person1.start();
        person2.start();
    }
}

class Person3 extends Thread {
    private int count;
    @Override
    public void run() {
        while (Number1.number == 100) {
            count++;
            System.out.println("嘿嘿" + count);
        }
        System.out.println("！！");
    }
}

class Person4 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        Number1.number = 90;
    }
}

class Number2 {
    public static volatile int number = 100;
}