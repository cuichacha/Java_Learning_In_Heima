package Day01.Code;

public class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    public void watchDoor() {
        System.out.println("看门");
    }
}
