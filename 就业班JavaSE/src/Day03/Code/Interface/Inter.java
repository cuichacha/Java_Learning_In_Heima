package Day03.Code.Interface;

public interface Inter {
    public static int NUM = 0;

    public abstract void method();

    public void method1();

    public default void method2() {
        System.out.println("---");
    }

    public static void method3() {
        Inter.method5();
    }

    private void method4() {

    }

    private static void method5() {

    }
}
