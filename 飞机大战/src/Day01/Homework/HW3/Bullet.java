package Day01.Homework.HW3;

public class Bullet extends FlyingObject {
    public Bullet() {
    }

    public Bullet(int abscissa, int ordinate, int height, int width) {
        super(abscissa, ordinate, height, width);
    }

    @Override
    public void draw() {
        System.out.println("创建子弹");
    }
}
