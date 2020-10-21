package Day02.Homework.Phone;

public class OldPhone {
    private String brand;

    public OldPhone() {
    }

    public OldPhone(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void call(String name) {
        System.out.println("正在给" + name + "打电话");
    }
}
