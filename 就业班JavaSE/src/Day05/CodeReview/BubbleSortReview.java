package Day05.CodeReview;

import java.util.Arrays;

public class BubbleSortReview {

    public static void main(String[] args) {
        int[] intArr = {7, 4, 6, 98, 0, 3, 2, 5, 6, 87, 4};
        System.out.println(Arrays.toString(bubbleSort(intArr)));
    }

    private static int[] bubbleSort(int[] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr.length - 1; j++) {
                if (intArr[j] > intArr[j + 1]) {
                    int temp = intArr[j];
                    intArr[j] = intArr[j + 1];
                    intArr[j + 1] = temp;
                }
            }
        }
        return intArr;
    }
}
