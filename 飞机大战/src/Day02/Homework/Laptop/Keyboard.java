package Day02.Homework.Laptop;

public class Keyboard implements USB {
    @Override
    public void turnOn() {
        System.out.println("连接键盘的USB");
    }

    @Override
    public void turnOff() {
        System.out.println("断开键盘的USB");
    }
}
