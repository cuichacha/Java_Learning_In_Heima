package Day02.Code.AbstractClass;

public class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("狗吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("狗睡觉");
    }
}
