package Day05.CodeReview;

import java.util.Arrays;

public class SystemReview {
    public static void main(String[] args) {
        int[] intArr1 = {1, 2, 3, 4, 5};
        int[] intArr2 = new int[7];

        long time1 = System.currentTimeMillis();
        System.arraycopy(intArr1, 0, intArr2, 2, 5);
        System.out.println(Arrays.toString(intArr2));
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        System.exit(0);

        for (int i = 0; i < intArr2.length; i++) {
            System.out.println(intArr2[i]);
        }
    }
}
