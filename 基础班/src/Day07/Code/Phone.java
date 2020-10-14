package Day07.Code;

public final class Phone {
    private String brand;
    private double price;

    public Phone(String brand, double price) {
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

    public final void call() {
        System.out.println("Call somebody");
    }

    public final void sendMessage() {
        System.out.println("Send messages");
    }
}
