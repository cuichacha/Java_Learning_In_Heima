package Day02.Homework.Phone;

public class NewPhone extends OldPhone {
    public NewPhone() {
    }

    public NewPhone(String brand) {
        super(brand);
    }

    @Override
    public void call(String name) {
        System.out.println("语音拨号中");
        super.call(name);
    }

    public void introduce() {
        System.out.println("品牌为" + getBrand() + "很好用");
    }
}
