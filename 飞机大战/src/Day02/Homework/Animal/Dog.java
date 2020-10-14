package Day02.Homework.Animal;

public class Dog extends Animal implements Jump {
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void run() {
        System.out.println("狗跑步");
    }

    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    @Override
    public void jump() {
        System.out.println("狗跳");
    }
}
