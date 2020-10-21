package Day04.Code;

import java.util.Random;

public class Lambda3 {
    public static void main(String[] args) {
        useRandomNumberGenerator(new RandomNumberGenerator() {
            @Override
            public int generateRandomNumber() {
                Random random = new Random();
                int result = random.nextInt(10) + 1;
                System.out.println(result);
                return result;
            }
        });

        useRandomNumberGenerator(() -> {
            Random random = new Random();
            int result =  random.nextInt(10) + 1;
            System.out.println(result);
            return result;
        });

    }

    public static void useRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        int result = randomNumberGenerator.generateRandomNumber();
    }
}

@FunctionalInterface
interface RandomNumberGenerator {
    public abstract int generateRandomNumber();
}
