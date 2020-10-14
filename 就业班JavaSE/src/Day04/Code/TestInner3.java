package Day04.Code;

public class TestInner3 {
    public static void main(String[] args) {
        Outer3.Inner3 outerInner = new Outer3.Inner3();
        outerInner.method1();
        Outer3.Inner3.method2();
    }
}

class Outer3 {
    private int number1 = 0;
    private static int number2 = 1;

    public void method() {
        Inner3 inner3 = new Inner3();
        inner3.method1();
    }

    static class Inner3 {
        int number = 2;

        public void method1() {
            System.out.println(number);
        }

        public static void method2() {
            System.out.println(number2);
        }
    }
}
