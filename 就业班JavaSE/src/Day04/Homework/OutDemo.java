package Day04.Homework;

public class OutDemo {
    public static void main(String[] args) {
        Outer.method().show();
    }
}

interface Inter {
    public abstract void show();
}

class Outer {
    private static int a = 10;
    public static Inter method() {
        return new Inter() {
            @Override
            public void show() {
                System.out.println("HelloWorld");
                System.out.println(a);
            }
        };

//        return () -> {
//            System.out.println("HelloWorld");
//        };

//        return () -> System.out.println("HelloWorld");
    }
}


