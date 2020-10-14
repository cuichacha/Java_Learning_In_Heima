package Day02.Homework.Phone;

public class OldPhone extends Phone {
    public OldPhone() {
    }

    public OldPhone(String brand, double price) {
        super(brand, price);
    }

    @Override
    public void call() {
        System.out.println("用旧手机打电话");
    }

    @Override
    public void sendMessage() {
        System.out.println("用旧手机发短信");
    }
}
