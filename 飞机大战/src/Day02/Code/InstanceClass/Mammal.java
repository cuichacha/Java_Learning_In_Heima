package Day02.Code.InstanceClass;

public class Mammal extends Animal {
    int age = 1;

    @Override
    public void eat() {
        System.out.println("哺乳动物吃饭");
    }


    public void move() {
        System.out.println("哺乳动物移动");
    }
}
