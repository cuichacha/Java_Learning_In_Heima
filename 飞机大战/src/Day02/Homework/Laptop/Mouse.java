package Day02.Homework.Laptop;

public class Mouse implements USB {
    @Override
    public void turnOn() {
        System.out.println("连接鼠标的USB");
    }

    @Override
    public void turnOff() {
        System.out.println("断开鼠标的USB");
    }
}
