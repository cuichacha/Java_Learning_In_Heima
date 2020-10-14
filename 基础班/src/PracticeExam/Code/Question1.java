package PracticeExam.Code;

import java.util.Arrays;
import java.util.Random;

public final class Question1 {
    public static void main(String[] args) {
        int[] arr = new int[5];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomNumber = random.nextInt(100) + 1;
            arr[i] = randomNumber;
        }
        System.out.println("随机生成的数组为" + Arrays.toString(arr));

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("数组中的最大值为" + max);

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println("数组中的最小值为" + min);

        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double avg = sum / arr.length;
        System.out.println("数组中的平均值为" + avg);

        System.out.println("内容和索引都是偶数的元素和索引为");
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0 && arr[i] % 2 == 0) {
                System.out.print(i + " ");
                System.out.print(arr[i] + " ");
            }
        }
    }
}
