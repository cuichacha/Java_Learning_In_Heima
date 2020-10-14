package Day05.Code;

public class RecursionDemo {
    public static void main(String[] args) {
        System.out.println(recursiveSum(100));
        System.out.println(recursiveFactorial(5));
    }

    private static int recursiveSum(int number) {
        if (number == 1) {
            return number;
        }
        return number + recursiveSum(number - 1);
    }

    private static int recursiveFactorial(int number) {
        if (number == 1) {
            return number;
        }
        return number * recursiveFactorial(number - 1);
    }


}
