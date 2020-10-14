package Day01.Homework.HW3;

public class Ball extends FlyingObject {
    public Ball() {
    }

    public Ball(int abscissa, int ordinate, int height, int width) {
        super(abscissa, ordinate, height, width);
    }

    @Override
    public void draw() {
        System.out.println("创建球");
    }
}
