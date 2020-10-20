package Day04.Code;

public class TestInner5 {
    public static void main(String[] args) {
        Outer5.Inner outerInner = new Outer5().new Inner();
        outerInner.method();
    }
}

class Outer5 {
    private int number = 0;

    public void method() {

    }

    public class Inner {
        private int number = 1;

        public void method() {
            System.out.println(number);
            System.out.println(Outer5.this.number);
        }
    }
}
