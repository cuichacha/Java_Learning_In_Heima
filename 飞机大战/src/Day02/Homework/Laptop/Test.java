package Day02.Homework.Laptop;

public class Test {
    public static void main(String[] args) {
        Laptop laptop = new Laptop("橘子", 99999.99);
        laptop.bootUp();
        USB usb1 = new Mouse();
        laptop.useUSB(usb1);
        USB usb2 = new Keyboard();
        laptop.useUSB(usb2);
        laptop.shutDown();
    }
}
