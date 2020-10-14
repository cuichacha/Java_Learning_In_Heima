package Day04.Code;

public class TestAnonymousClass3 {
    public static void main(String[] args) {
//        method5(new abstractTest() {
//            @Override
//            public int method2() {
//                System.out.println();
//                return 5;
//            }
//
//            @Override
//            public void method9() {
//
//            }
//        });
//
//        method4(new Inter() {
//            @Override
//            public void method1() {
//                System.out.println();
//            }
//        });
//
//        new Test02().method8();
//        new Test().method3();
//
//        method6(new Test().method3());

        Inter inter1 = new Inter() {
            @Override
            public void method1() {
                System.out.println();
            }
        };

        method9(new Test02(){
            @Override
            public int method2() {
                System.out.println("匿名内部类形式继承抽象类");
                return 5;
            }

            @Override
            public void method9() {
                System.out.println();
            }
        }.method2());

        new Test02(){
            @Override
            public int method2() {
                System.out.println("直接使用");
                return 5;
            }
        }.method2();

        new Test03(){
            @Override
            public int method3() {
                System.out.println("000000");
                return 5;
            }
        }.method3();

        Test test = new Test03(){
            @Override
            public int method3() {
                System.out.println();
                return 5;
            }
        };

        AbstractTest abstractTest = new AbstractTest(){
            @Override
            public int method2() {
                return 0;
            }

            @Override
            public void method9() {

            }
        };
//        abstractTest.method2();
//        abstractTest.method9();

    }

    public static void method4(Inter inter) {
        System.out.println("...");
    }

    public static void method5(AbstractTest abstractTest) {
        System.out.println(",,,");
    }

    public static void method6(int num) {
        System.out.println(";;;");
    }

    public static void method9(int num) {
//        System.out.println();
    }
}


class Test {
    public int method3() {
        System.out.println("---------");
        return 5;
    }
}

class Test03 extends Test {

}

abstract class AbstractTest {
    public abstract int method2();
    public abstract void method9();
    public void show() {
        System.out.println("你好");
    }
}

@FunctionalInterface
interface Inter {
    public abstract void method1();
}

class Test02 extends AbstractTest {
    public void method8() {
        System.out.println("哈哈哈");
    }

    @Override
    public int method2() {
        System.out.println("普通继承抽象类");
        return 5;
    }

    @Override
    public void method9() {
        System.out.println("普通继承抽象类");
    }
}