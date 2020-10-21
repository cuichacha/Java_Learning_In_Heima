package Day04.Code;

import java.util.Random;

public class Lambda5 {
    private static double a;
    private static double b;

    public static void main(String[] args) {
        useDoubleSum(new DoubleSum() {
            @Override
            public double sum(double a, double b) {
                return a + b;
            }
        });

        useDoubleSum((double a, double b) -> {
            return a + b;
        });

        useDoubleSum((a, b) -> a + b);
    }

    public static void useDoubleSum(DoubleSum doubleSum) {
        Random random = new Random();
        a = random.nextDouble() * 10;
        b = random.nextDouble() * 10;
        double sum = doubleSum.sum(a, b);
        System.out.println(sum);
    }
}

@FunctionalInterface
interface DoubleSum {
    public abstract double sum(double a, double b);
}
