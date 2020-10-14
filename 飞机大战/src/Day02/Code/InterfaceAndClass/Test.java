package Day02.Code.InterfaceAndClass;

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat("加菲", 1);
        Dog dog = new Dog("哈哈", 1);

        System.out.println(cat.getName() + "..." + cat.getAge());
        System.out.println(dog.getName() + "..." + dog.getAge());

        cat.jump();
        dog.jump();
    }
}
