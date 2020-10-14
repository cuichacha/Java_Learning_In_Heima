package Day02.Homework.Door;

public class WoodenDoor extends Door {
    public WoodenDoor() {
    }

    public WoodenDoor(double width, double height, String color) {
        super(width, height, color);
    }

    @Override
    public void openDoor() {
        System.out.println(getHeight() + "\t" + getWidth() + "\t" + getColor() + "\t" + "门已打开");
    }

    @Override
    public void shutDoor() {
        System.out.println(getHeight() + "\t" + getWidth() + "\t" + getColor() + "\t" + "门已关闭");
    }
}
