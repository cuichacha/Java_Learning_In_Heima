package Day13.CodeReview;

public class ProducerConsumerPatternReview2 {
    // 生产者消费者模型创建对象改进

    public static void main(String[] args) {
        Goods2 goods2 = new Goods2(50, 2);
        MyThread7 myThread7 = new MyThread7(goods2, "消费者");
        MyThread8 myThread8 = new MyThread8(goods2, "生产者");
        myThread7.start();
        myThread8.start();
    }
}

class Goods2 {
    private int count;
    private int goodsNumber;

    public Goods2(int count, int goodsNumber) {
        this.count = count;
        this.goodsNumber = goodsNumber;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }
}

class MyThread7 extends Thread {

    private Goods2 goods2;

    public MyThread7(Goods2 goods2, String name) {
        super(name);
        this.goods2 = goods2;
    }



    @Override
    public void run() {
        while (goods2.getCount() > 0) {
            synchronized (Goods2.class) { // 同步锁的对象，监视器对象，为类的对象
                if (goods2.getGoodsNumber() > 0) {
                    goods2.setCount(goods2.getCount() - 1); // 吃一次，一共吃50次
                    System.out.println(getName() + "消耗一个商品" + goods2.getCount());
                    goods2.setGoodsNumber(goods2.getGoodsNumber() - 1);
                    if (goods2.getCount() == 0) {
                        Goods2.class.notifyAll();
                    }
                } else {
                    try {
//                        Goods.class.notifyAll(); // 监视器对象上，每次只有最多一个线程在等待，所以不需要使用notifyAll()
                        Goods2.class.notify();
                        Goods2.class.wait();
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }
    }
}


class MyThread8 extends Thread {
    private Goods2 goods2;

    public MyThread8(Goods2 goods2, String name) {
        super(name);
        this.goods2 = goods2;
    }

    @Override
    public void run() {
        while (goods2.getCount() > 0) {
            synchronized (Goods2.class) {
                if (goods2.getGoodsNumber() > 0) {
                    try {
//                        Goods.class.notifyAll();
                        Goods2.class.notify();
                        Goods2.class.wait();
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                } else {
//                    Goods.setCount(Goods.getCount() - 1); // 吃一次，一共吃100次
                    System.out.println(getName() + "生产一个商品" + goods2.getCount());
                    goods2.setGoodsNumber(goods2.getGoodsNumber() + 1);
                }
            }
        }
    }
}
