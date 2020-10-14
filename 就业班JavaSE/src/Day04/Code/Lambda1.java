package Day04.Code;

public class Lambda1 {
    public static void main(String[] args) {
        show(new Inter2() {
            @Override
            public void method() {
                System.out.println("啦啦啦");
            }
        });

        show(() -> {
            System.out.println("嘟嘟嘟");
        });

        show(() -> System.out.println("嘟嘟嘟"));
    }

    public static void show(Inter2 inter2) {
        inter2.method();
    }
}


@FunctionalInterface
interface Inter2 {
    public abstract void method();
}
