package Day07.Code;

public final class TestPhone {
    public static void main(String[] args) {
        Phone phone = new Phone("橘子", 9999.99);

        String brand = phone.getBrand();
        double price = phone.getPrice();

        System.out.println(brand + " " + price);
        phone.call();
        phone.sendMessage();
    }
}
