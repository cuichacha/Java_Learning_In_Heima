package Day07.Homework2;

public class TestPhone {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.setBrand("橘子");
        phone.setPrice(9999.99);
        phone.setColor("黑色");

        phone.call();
        phone.sendMessage();
    }
}
