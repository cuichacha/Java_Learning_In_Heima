package Day08.Code;

public class GenericsDemo4 {
    public static void main(String[] args) {
        GenericsImpl1<Integer> genericsImpl1 = new GenericsImpl1<>();
        genericsImpl1.method(123);

        GenericsImpl2 genericsImpl2 = new GenericsImpl2();
        genericsImpl2.method("123");
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
