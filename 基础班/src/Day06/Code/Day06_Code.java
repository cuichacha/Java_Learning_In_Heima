package Day06.Code;

import java.util.Arrays;

public class Day06_Code {

    public static void main(String[] args) {
        Day06_Code day06_code = new Day06_Code();
//        day06_code.twoDimensionalArray();
        day06_code.iterateTwoDimensionalArray();
    }

    private void oneSComplement() {
        /*
            200
            00000000 00000000 00000000 11001000
            强转后补码：11001000

            反码：11000111
            原码：10111000


         */
//        byte b = (byte) 200;
//        System.out.println(b);
//        System.out.println(0b0111000);
    }

    private void swapValue() {
        int a = 10;
        int b = 20;
//        int temp = a;
//        a = b;
//        b = temp;
//        System.out.println(a + " " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }

    private void reverseArray(int[] arr) {
        for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    private void twoDimensionalArray() {
        int[][] tarr = new int[2][3];
//        System.out.println(tarr[1][3]);

        int[] arr = {1, 2, 3, 4, 5};
        tarr[1] = arr;

        System.out.println(tarr[1][3]);
    }

    private void iterateTwoDimensionalArray() {
        int sum = 0;
        int[][] tarr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        for (int i = 0; i < tarr.length; i++) {
            for (int j = 0; j < tarr[i].length; j++) {
                System.out.println(tarr[i][j]);
                sum += tarr[i][j];
            }
        }
        System.out.println("数组中所有元素的和为：" + sum);
    }
}

