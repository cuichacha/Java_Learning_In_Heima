package Day02.Code.InterfaceAndClass;

public class Dog extends Animal implements Jump {
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void jump() {
        System.out.println("狗跳高");
    }
}
