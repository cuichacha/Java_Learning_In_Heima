package Day02.Homework.Laptop;

public class Laptop {
    private String brand;
    private double price;

    public Laptop() {
    }

    public Laptop(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void bootUp() {
        System.out.println("开机");
    }

    public void shutDown() {
        System.out.println("关机");
    }

    public void useUSB(USB usb) {
        usb.turnOn();
        usb.turnOff();
    }

}
