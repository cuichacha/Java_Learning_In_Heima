package Day14.Homework;

public class Question2 {
    public static void main(String[] args) {
        MyRunnable2 myRunnable2 = new MyRunnable2();
        myRunnable2.setNum(100);
        new Thread(myRunnable2).start();
    }
}

class MyRunnable2 implements Runnable {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(sum(num));
    }

    private int sum(int number) {
        if (number == 1) {
            return 1;
        } else {
            return number + sum(number - 1);
        }

    }
}