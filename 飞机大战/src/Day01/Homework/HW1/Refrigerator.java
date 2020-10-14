package Day01.Homework.HW1;

public class Refrigerator extends HomeAppliance {
    private String doorStyle;
    private String freezingWay;

    public Refrigerator() {
    }

    public Refrigerator(String doorStyle, String freezingWay) {
        this.doorStyle = doorStyle;
        this.freezingWay = freezingWay;
    }
}
