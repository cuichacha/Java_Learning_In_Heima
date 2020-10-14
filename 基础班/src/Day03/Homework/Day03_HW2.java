package Day03.Homework;

public class Day03_HW2 {
    public static void main(String[] args) {
        for (int j = 1; j <= 5; j++) {
            System.out.println(j);
        }
        System.out.println("--------------");

        for (int j = 5; j >= 1; j--) {
            System.out.println(j);
        }
        System.out.println("--------------");

        int sum1 = 0;
        for (int j = 1; j <= 100; j++) {
            sum1 += j;
        }
        System.out.println(sum1);
        System.out.println("--------------");

        int sum2 = 0;
        for (int j = 1; j <= 100; j++) {
            if (j % 2 == 0) {
                sum2 += j;
            }
        }
        System.out.println(sum2);
        System.out.println("--------------");

        int gewei;
        int shiwei;
        int baiwei;
        int count = 0;
        for (int j = 100; j <= 999; j++) {
            gewei = j % 10;
            shiwei = (j / 10) % 10;
            baiwei = (j / 10 / 10) % 10;
            if (j == ((gewei * gewei * gewei) + (shiwei * shiwei * shiwei) + (baiwei * baiwei * baiwei))) {
                count++;
                System.out.print(j + " ");
                if (count % 2 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println("共计" + count + "个水仙花数");
    }
}