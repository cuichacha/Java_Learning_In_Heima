package Day04.Code;

import java.util.Random;

public class Lambda4 {
    private static int a;
    private static int b;

    public static void main(String[] args) {
        useSum(new Sum() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        });

        useSum((int a, int b) -> {
            return a + b;
        });

        useSum((a, b) -> a + b);
    }

    public static void useSum(Sum sum) {
        Random random = new Random();
        a = random.nextInt(10) + 1;
        b = random.nextInt(10) + 1;
        int result = sum.sum(a, b);
        System.out.println(result);
    }
}

@FunctionalInterface
interface Sum {
    public abstract int sum(int a, int b);
}
