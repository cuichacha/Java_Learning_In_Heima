package Day04.Code;

public class TestInner4 {
    public static void main(String[] args) {
        Outer4 outer4 = new Outer4();
        outer4.method1();
    }
}

class Outer4 {
    private int number1 = 0;

    public void method1() {
        int number2 = 1;

        class Inner {
            int number3 = 2;

            public void method2() {
                System.out.println(number3);
                System.out.println(number2);
                System.out.println(number1);
            }
        }

        Inner inner = new Inner();
        inner.method2();
    }
}


