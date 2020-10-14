package Day01.Homework.HW2;

public class Snake extends Reptile {
    public Snake() {
    }

    public Snake(int age, String gender) {
        super(age, gender);
    }

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public void sleep() {
        super.sleep();
    }

    @Override
    public void move() {
        System.out.println("滑行");
    }
}
