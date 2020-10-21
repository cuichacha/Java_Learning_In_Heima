package Day03.Homework.Practice.Animal;

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Human man = new Human();

        man.play(cat);
        man.play(dog);
    }
}
