package Question20;

import java.util.Arrays;
import java.util.Random;

public final class Question20 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = random.nextInt(99) + 1;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(getScore(arr));
    }

    private static int getScore(int[] arr) {
        int sum = 0;
        int count = 0;
        double avg;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        avg = sum * 1.0 / arr.length;
//        System.out.println(avg);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > avg) {
                count++;
            }
        }
        return count;
    }
}
