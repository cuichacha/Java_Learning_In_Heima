package Day04.Code;

public class Lambda2 {
    private static String str = "啦啦啦";

    public static void main(String[] args) {
        useStringHandler(new StringHandler() {
            @Override
            public void printMessage(String msg) {
                System.out.println("匿名内部类" + str);
            }
        });

        useStringHandler((String str) -> {
            System.out.println("Lambda表达式" + str);
        });

        useStringHandler(str -> System.out.println("Lambda表达式" + str));
    }

    public static void useStringHandler(StringHandler stringHandler) {
        stringHandler.printMessage(str);
    }
}

@FunctionalInterface
interface StringHandler {
    public abstract void printMessage(String msg);
}
