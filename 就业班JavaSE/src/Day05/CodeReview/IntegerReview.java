package Day05.CodeReview;

public class IntegerReview {
    public static void main(String[] args) {
        Integer integer1 = Integer.valueOf(50);
        Integer integer2 = Integer.valueOf("50");
        Integer integer3 = 50;
        int num1 = integer3;
        int num2 = integer3.intValue();

        Double double1 = Double.valueOf(23.3);
        Double double2 = Double.valueOf("23.3");
        Double double3 = 23.3;
        double double4 = double3;
        double double5 = double3.doubleValue();

        // int ---> String
        long time1 = System.currentTimeMillis();
        int num3 = 55;
        String num4 = num3 + "";
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);

        long time3 = System.currentTimeMillis();
        int num5 = 66;
        String num6 = String.valueOf(num5);
        long time4 = System.currentTimeMillis();
        System.out.println(time4 - time3);

        long time5 = System.currentTimeMillis();
        int num7 = 77;
        String num8= Integer.toString(num7);
        long time6 = System.currentTimeMillis();
        System.out.println(time6 - time5);

        // String ---> int
        int num9 = Integer.parseInt("12");
        int num10 = Integer.valueOf("12");

    }
}
