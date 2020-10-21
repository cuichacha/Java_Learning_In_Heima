package Day05.Homework;

public class Phone {
    private String brand;
    private String color;
    private double price;

    public Phone() {
    }

    public Phone(String brand, String color, double price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

}

class TestPhone {
    public static void main(String[] args) {
        Phone phone1 = new Phone("橘子", "黑色", 9999.99);
        Phone phone2 = new Phone();
        phone2.setBrand("橙子");
        phone2.setColor("黑色");
        phone2.setPrice(9999.99);

        System.out.println(phone1);
        System.out.println(phone2);
    }
}
