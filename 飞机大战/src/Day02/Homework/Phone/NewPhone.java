package Day02.Homework.Phone;

public class NewPhone extends Phone implements Play {
    public NewPhone() {
    }

    public NewPhone(String brand, double price) {
        super(brand, price);
    }

    @Override
    public void call() {
        System.out.println("用新手机打电话");
    }

    @Override
    public void sendMessage() {
        System.out.println("用新手机发短信");
    }

    @Override
    public void playGames() {
        System.out.println("用新手机玩游戏");
    }
}
