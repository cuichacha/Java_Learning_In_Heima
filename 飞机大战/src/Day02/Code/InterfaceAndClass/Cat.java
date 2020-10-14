package Day02.Code.InterfaceAndClass;

public class Cat extends Animal implements Jump {
    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void jump() {
        System.out.println("猫跳高");
    }
}
