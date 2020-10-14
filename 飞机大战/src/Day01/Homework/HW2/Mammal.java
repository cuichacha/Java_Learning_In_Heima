package Day01.Homework.HW2;

public class Mammal extends Animal {
    public Mammal() {
    }

    public Mammal(int age, String gender) {
        super(age, gender);
    }

    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void move() {
        System.out.println("走");
        System.out.println("跑");
    }
}
