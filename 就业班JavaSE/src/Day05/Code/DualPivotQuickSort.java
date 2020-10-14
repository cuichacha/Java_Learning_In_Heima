package Day05.Code;

import java.util.Arrays;

public class DualPivotQuickSort {


    public static void main(String[] args) {
        int[] intArr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        System.out.println(Arrays.toString(quickSort(intArr, 0, intArr.length - 1)));
    }

    private static int[] quickSort(int[] intArr, int left, int right) {
        if (left > right) {
            return null;
        }

        int initialLeft = left;
        int initialRight = right;
        int baseNumber = intArr[initialLeft];

        while (left != right) {
            while (intArr[right] >= baseNumber && left < right) {
                right--;
            }

            while (intArr[left] <= baseNumber && left < right) {
                left++;
            }

            int temp = intArr[left];
            intArr[left] = intArr[right];
            intArr[right] = temp;
        }

        int temp = intArr[left];
        intArr[left] = intArr[initialLeft];
        intArr[initialLeft] = temp;

        quickSort(intArr, initialLeft, left - 1);
        quickSort(intArr, left + 1, initialRight);
        return intArr;
    }
}
