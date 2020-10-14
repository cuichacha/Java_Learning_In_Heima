package Day03.Code.Polymorphism;

public class Son extends Father {
    int number = 1;

    @Override
    public void method() {
        System.out.println("儿子的method");
    }

    public void method1() {
        System.out.println("儿子自己的method1");
    }
}
