package Day03.Code.Polymorphism;

public class Test {
    public static void main(String[] args) {
        Father father = new Son();
        System.out.println(father.number);
        father.method();

        method(new Son());
        method(new Daughter());

        Son son = (Son) father;
        son.method1();

        Father f = new Daughter();
        f.method();
        if (f instanceof Son) {
            Son s = (Son) f;
            s.method1();
        }


    }

    public static void method(Father father) {
        father.method();
    }
}
