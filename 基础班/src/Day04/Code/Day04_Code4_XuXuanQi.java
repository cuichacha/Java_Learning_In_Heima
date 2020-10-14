package Day04.Code;

import java.util.Random;

public class Day04_Code4_XuXuanQi {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[7];
        for (int i = 0; i < 7; ) {
            int a = random.nextInt(33) + 1;
            for (int j = 0; j < i; j++) {
                if (a == arr[j]) {
                    a = random.nextInt(33) + 1;
                    j = -1;
                }
            }
            arr[i++] = a;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
