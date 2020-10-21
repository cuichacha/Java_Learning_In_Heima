package Day04.Code;

public class TestAnonymousClass2 {
    public static void main(String[] args) {
        swimming(new Swimming() {
            @Override
            public void swimming() {
                System.out.println("游泳");
            }
        });
    }

    public static void swimming(Swimming swimming) {
        swimming.swimming();
    }
}

interface Swimming {
    public abstract void swimming();
}
