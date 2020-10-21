package Day04.Code;

public class TestAnonymousClass1 {
    public static void main(String[] args) {
        new Inter1(){
            @Override
            public void method1() {
                System.out.println("啦啦啦");
            }

            @Override
            public void method2() {
                System.out.println("嘟嘟嘟");
            }
        }.method1();

        Inter1 inter1 = new Inter1() {
            @Override
            public void method1() {
                System.out.println("拉拉拉");
            }

            @Override
            public void method2() {
                System.out.println("滴滴滴");
            }
        };

        inter1.method1();
        inter1.method2();
    }
}

interface Inter1 {
    public abstract void method1();

    public abstract void method2();
}
