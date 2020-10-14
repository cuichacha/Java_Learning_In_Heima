package Day08.CodeReview;

public class GenericsReview3 {
    public static void main(String[] args) {
        GenericsImpl1<String> genericsImpl1 = new GenericsImpl1<>();
        genericsImpl1.method("111");
        GenericsImpl2 genericsImpl2 = new GenericsImpl2();
        genericsImpl2.method("222");

        new Generics<String>() {
            @Override
            public void method(String s) {
                System.out.println(s);
            }
        }.method("333");

        new GenericsImpl1<String>() {
            @Override
            public void method(String s) {
                System.out.println(s);
            }
        }.method("444");

        new GenericsImpl2().method("555");
    }
}

interface Generics<E> {
    public abstract void method(E e);
}

class GenericsImpl1<E> implements Generics<E> {
    @Override
    public void method(E e) {
        System.out.println(e);
    }
}

class GenericsImpl2 implements Generics<String> {
    @Override
    public void method(String s) {
        System.out.println(s);
    }
}
