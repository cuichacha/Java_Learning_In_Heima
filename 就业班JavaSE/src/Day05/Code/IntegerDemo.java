package Day05.Code;

import java.util.Arrays;

public class IntegerDemo {
    public static void main(String[] args) {
        Integer integer1 = Integer.valueOf(10);
        Integer integer2 = 10;
        Integer integer3 = Integer.valueOf("10");
//        Integer integer4 = "10";
        System.out.println(integer3 + 20);

        int number1 = 10;
        String str1 = number1 + "";

        String str2 = String.valueOf(number1);

        String str3 = Integer.toString(number1);

        String number2 = "10";

        int number3 = Integer.parseInt(number2);

        int number4 = Integer.valueOf(number2).intValue();

        String str = "10 20 30 40 50";
        String[] strArr = str.split(" ");
        int[] intArr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        System.out.println(Arrays.toString(intArr));
    }

}
