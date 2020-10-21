package Day05.CodeReview;

import java.util.Arrays;

public class DualPivotSortReview {
    public static void main(String[] args) {
        int[] intArr = {7, 4, 6, 98, 0, 3, 2, 5, 6, 87, 4};
        int left = 0;
        int right = intArr.length - 1;
        System.out.println(Arrays.toString(dualPivotSort(intArr, left, right)));
    }

    private static int[] dualPivotSort(int[] intArr, int left, int right) {
        if (left > right) {
            return null;
        }

        int initialLeft = left;
        int initialRight = right;

        int baseNumber = intArr[initialLeft];

        while (left != right) {
            while (baseNumber <= intArr[right] && left < right) {
                right--;
            }
            while (baseNumber >= intArr[left] && left < right) {
                left++;
            }

            int temp = intArr[left];
            intArr[left] = intArr[right];
            intArr[right] = temp;
        }

        int temp = intArr[left];
        intArr[left] = intArr[initialLeft];
        intArr[initialLeft] = temp;

        dualPivotSort(intArr, initialLeft, right - 1);
        dualPivotSort(intArr, left + 1, initialRight);
        return intArr;
    }
}
