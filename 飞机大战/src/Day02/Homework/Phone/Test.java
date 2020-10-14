package Day02.Homework.Phone;

public class Test {
    public static void main(String[] args) {
        OldPhone oldPhone = new OldPhone("诺基亚", 999.9);
        NewPhone newPhone = new NewPhone("橘子", 9999.9);

        System.out.println(oldPhone.getBrand() + "..." + oldPhone.getPrice());
        oldPhone.call();
        oldPhone.sendMessage();

        System.out.println(newPhone.getBrand() + "..." + newPhone.getPrice());
        newPhone.call();
        newPhone.sendMessage();
    }
}
