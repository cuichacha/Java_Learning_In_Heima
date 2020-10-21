package Day10.Code;

public class VariableParameterDemo1 {
    public static void main(String[] args) {
        System.out.println(getSum1(1, 2, 3));
        System.out.println(getSum1(1, 2, 3, 4, 5));

        System.out.println(getSum2(1, 1, 2, 3));
        System.out.println(getSum2(1, 1, 2, 3, 4, 5));
    }

    private static int getSum1(int... arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }

    private static int getSum2(int number, int... arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum + number;
    }

}
