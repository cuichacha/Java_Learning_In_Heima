package Day01.Homework.HW3;

public class Plane extends FlyingObject {
    public Plane() {
    }

    public Plane(int abscissa, int ordinate, int height, int width) {
        super(abscissa, ordinate, height, width);
    }

    @Override
    public void draw() {
        System.out.println("创建飞机");
    }
}
