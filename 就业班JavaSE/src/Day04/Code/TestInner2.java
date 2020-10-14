package Day04.Code;

public class TestInner2 {
    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        outer2.method();
    }
}

class Outer2 {
    private int number = 0;
    Inner2 inner2 = new Inner2();

    public void method() {
        System.out.println(number);
        inner2.method();
    }

    private class Inner2 {
        int number = 1;
        public void method() {
            System.out.println(number);
        }
    }
}
