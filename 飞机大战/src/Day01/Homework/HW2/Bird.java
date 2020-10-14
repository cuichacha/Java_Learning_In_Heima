package Day01.Homework.HW2;

public class Bird extends Animal {

    public Bird() {
    }

    public Bird(int age, String gender) {
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
        System.out.println("飞");
    }
}
