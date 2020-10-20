package Day02.Homework.Door;

public class Door {
    private double width;
    private double height;
    private String color;

    public Door() {
    }

    public Door(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void openDoor() {
        System.out.println("开门");
    }

    public void shutDoor() {
        System.out.println("关门");
    }
}
