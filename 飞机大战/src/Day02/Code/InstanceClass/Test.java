package Day02.Code.InstanceClass;

public class Test {
    public static void main(String[] args) {
        Animal animal = new Mammal();
        Mammal mammal = new Mammal();

        animal.eat();
        animal.sleep();
        mammal.sleep();

    }
}
