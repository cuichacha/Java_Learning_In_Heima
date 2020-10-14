package Day02.Homework.Animal;

public class Cat extends Animal implements Jump {
    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void run() {
        System.out.println("猫跑步");
    }

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    @Override
    public void jump() {
        System.out.println("猫跳");
    }
}
