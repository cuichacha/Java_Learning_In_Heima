package Day08.Homework;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetQuestion2 {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入6个红色球号码");
        for (int i = 1; i <= 6; i++) {
            System.out.println("请输入第" + i + "个红色球号码");
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (set.contains(number)) {
                    System.out.println("请勿输入相同号码");
                    i--;
                } else if (number < 1 || number > 33) {
                    System.out.println("请输入范围内号码");
                    i--;
                } else {
                    set.add(number);
                }
            } catch (NumberFormatException e) {
//                e.printStackTrace();
                System.out.println("请输入正确格式的数字！！！");
                i--;
            }
        }
        while (true) {
            System.out.println("请输入蓝色球号码");
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (number >= 1 && number <= 16) {
                    set.add(number);
                    break;
                } else {
                    System.out.println("请输入范围内号码");
                }
            } catch (NumberFormatException e) {
//                e.printStackTrace();
                System.out.println("请输入正确格式的数字！！！");
            }
        }
        System.out.println("您下注的号码为");
        System.out.println(Arrays.toString(set.toArray(new Integer[set.size()])));
    }
}
