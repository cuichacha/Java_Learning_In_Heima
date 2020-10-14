package Day01.Code;

public final class SubClass extends SuperClass {
    public SubClass() {
        System.out.println("子类");
    }

    public SubClass(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println("儿子");
    }

}
