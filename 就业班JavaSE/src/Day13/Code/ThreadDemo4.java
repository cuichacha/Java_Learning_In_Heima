package Day13.Code;

public class ThreadDemo4 {
    public static void main(String[] args) {
        MyThread2 thread1 = new MyThread2();
        MyThread2 thread2 = new MyThread2();
        thread1.setName("啦啦");
        thread2.setName("嘟嘟");
        thread1.start();
        thread2.start();
        MyThread2 thread3 = new MyThread2("嘿嘿");
        MyThread2 thread4 = new MyThread2("哈哈");
        thread3.start();
        thread4.start();
    }
}

class MyThread2 extends Thread {
    public MyThread2() {
    }

    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getId() + "-" + getName() + "-" + i);
        }
    }
}