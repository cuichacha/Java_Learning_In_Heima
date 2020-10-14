package Day02.Code.AbstractClass;

public class Test {
    public static void main(String[] args) {
        Animal animal1 = new Cat("加菲", 0);
        Animal animal2 = new Dog("哈哈", 0);

        System.out.println(animal1.getName() + "..." + animal1.getAge());
        animal1.eat();
        animal1.sleep();
        System.out.println(animal2.getName() + "..." + animal2.getAge());
        animal2.eat();
        animal2.sleep();
    }
}
