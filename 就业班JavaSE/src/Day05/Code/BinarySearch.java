package Day05.Code;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] ints1 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binarySearch(ints1, 7));
        int[] ints2 = {4, -4, 67, 54, 6, 834, 67, 7, 82, 43, 5};
        System.out.println(Arrays.toString(bubbleSort(ints2)));
        System.out.println(binarySearch(ints2, 89));
    }

    private static int[] bubbleSort(int[] intArr) {
        for (int i = 0; i < intArr.length - 1; i++) {
            for (int j = 0; j < intArr.length - 1 - i; j++) {
                if (intArr[j] > intArr[j + 1]) {
                    int temp = intArr[j];
                    intArr[j] = intArr[j + 1];
                    intArr[j + 1] = temp;
                }
            }
        }
        return intArr;
    }

    private static int binarySearch(int[] intArr, int number) {
        int minIndex = 0;
        int maxIndex = intArr.length - 1;

        while (minIndex <= maxIndex) {
            int midIndex = (minIndex + maxIndex) >> 1;
            if (intArr[midIndex] > number) {
                maxIndex = midIndex - 1;
            } else if (intArr[midIndex] < number) {
                minIndex = midIndex + 1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }
}
