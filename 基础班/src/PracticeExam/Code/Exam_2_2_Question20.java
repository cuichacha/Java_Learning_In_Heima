package PracticeExam.Code;

import java.util.Arrays;
import java.util.Random;

public final class Exam_2_2_Question20 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(99) + 1;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(getScore(arr));
    }

    private static int getScore(int[] arr) {
        int sum = 0;
        double avg;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        avg = sum / arr.length;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > avg) {
                count++;
            }
        }
        return count;
    }
}
