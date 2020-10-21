package Day13.Homework;

public class Question3 {
    public static void main(String[] args) {
        final int[] count = {100};

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count[0] > 0) {
                    count[0]--;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                    System.out.println("播放背景音乐");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count[0] > 0) {
                    count[0]--;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                    System.out.println("显示画面");
                }
            }
        }).start();
    }
}
