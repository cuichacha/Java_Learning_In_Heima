package Day13.CodeReview;

public class ProducerConsumerPatternReview1 {
    public static void main(String[] args) {
        MyThread5 myThread5 = new MyThread5("消费者");
        MyThread6 myThread6 = new MyThread6("生产者");
        myThread5.start();
        myThread6.start();
    }
}

class Goods1 {
    private static int count = 50;
    private static int goodsNumber = 2;

    public static int getCount() {
        return count;
    }

    public static int getGoodsNumber() {
        return goodsNumber;
    }


    public static void setCount(int count) {
        Goods1.count = count;
    }


    public static void setGoodsNumber(int goodsNumber) {
        Goods1.goodsNumber = goodsNumber;
    }
}

class MyThread5 extends Thread {
    public MyThread5(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (Goods1.getCount() > 0) {
            synchronized (Goods1.class) { // 同步锁的对象，监视器对象，为类的对象
                if (Goods1.getGoodsNumber() > 0) {
                    Goods1.setCount(Goods1.getCount() - 1); // 吃一次，一共吃50次
                    System.out.println(getName() + "消耗一个商品" + Goods1.getCount());
                    Goods1.setGoodsNumber(Goods1.getGoodsNumber() - 1);
                    if (Goods1.getCount() == 0) {
                        Goods1.class.notifyAll();
                    }
                } else {
                    try {
//                        Goods.class.notifyAll(); // 监视器对象上，每次只有最多一个线程在等待，所以不需要使用notifyAll()
                        Goods1.class.notify();
                        Goods1.class.wait();
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }
    }
}


class MyThread6 extends Thread {
    public MyThread6(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (Goods1.getCount() > 0) {
            synchronized (Goods1.class) {
                if (Goods1.getGoodsNumber() > 0) {
                    try {
//                        Goods.class.notifyAll();
                        Goods1.class.notify();
                        Goods1.class.wait();
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                } else {
//                    Goods.setCount(Goods.getCount() - 1); // 吃一次，一共吃100次
                    System.out.println(getName() + "生产一个商品" + Goods1.getCount());
                    Goods1.setGoodsNumber(Goods1.getGoodsNumber() + 1);
                }
            }
        }
    }
}
