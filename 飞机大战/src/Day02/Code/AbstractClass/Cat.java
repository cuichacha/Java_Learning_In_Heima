package Day02.Code.AbstractClass;

public class Cat extends Animal {
    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("猫吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("猫睡觉");
    }

}
