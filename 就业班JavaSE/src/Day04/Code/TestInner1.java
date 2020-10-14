package Day04.Code;

public class TestInner1 {
    public static void main(String[] args) {
        Outer1.Inner1 outerInner1 = new Outer1().new Inner1();
        outerInner1.method();
    }
}

class Outer1 {
    private int number = 0;

    private void method() {
        System.out.println(number);
        Inner1 inner1 = new Inner1();
        System.out.println(inner1.number);
//        inner.method(); 循环调用方法，导致stackoverflow异常，栈内存空间小速度快，1M大小
    }

    class Inner1 {
        int number = 1;

        public void method() {
            System.out.println(number);
            System.out.println(Outer1.this.number);
            Outer1.this.method();
            method();
        }
    }
}
