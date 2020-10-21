package Day02.Homework.Animal;

public class Test {
    public static void main(String[] args) {
        Cat dog = new Cat("狗", 0);
        System.out.println(dog.getName() + "..." + dog.getAge());
        dog.eat();
        Dog cat = new Dog("猫", 0);
        System.out.println(cat.getName() + "..." + cat.getAge());
        cat.eat();
    }
}
