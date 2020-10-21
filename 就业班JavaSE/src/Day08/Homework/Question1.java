package Day08.Homework;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = new TreeSet<>();
        while (true) {
            System.out.println("请输入整数");
            String number = scanner.nextLine();
            try {
                int num = Integer.parseInt(number);
                if (num == -1) {
                    break;
                } else {
                    set.add(num);
                }
            } catch (RuntimeException e) {
//                e.printStackTrace();
                System.out.println("请输入正确形式的整数！！！");
            }
        }

        int count = 0;
        int sum = 0;
        for (Integer integer : set) {
            sum += integer;
            count++;
        }
        System.out.println("平均值为" + (sum / count));
    }
}
