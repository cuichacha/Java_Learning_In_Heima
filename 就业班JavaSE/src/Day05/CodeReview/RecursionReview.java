package Day05.CodeReview;

public class RecursionReview {
    public static void main(String[] args) {
        System.out.println(recursiveSum(100));
        System.out.println(recursiveFactorial(5));
    }

    private static int recursiveSum(int num) {
        if (num == 1) {
            return 1;
        }
        return num + recursiveSum(num - 1);
    }

    private static int recursiveFactorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * recursiveFactorial(num - 1);
    }
}
