package Day04.Code;

import java.util.Random;

public class Day04_Code3 {
    public static void main(String[] args) {
        int[] arr = new int[7];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomNumber = random.nextInt(33) + 1;
            arr[i] = randomNumber;
            for (int j = i; j > 0; j--) {
                if (arr[i] == arr[j - 1]) {
                    i--;
                    break;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

