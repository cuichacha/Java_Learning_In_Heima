package Day02.Homework.Audi;

public class ExpensiveAudi extends Car implements FancyFunctions {
    public ExpensiveAudi() {
    }

    public ExpensiveAudi(String model) {
        super(model);
    }

    @Override
    public void run() {
        System.out.println("开高级奥迪车");
    }

    @Override
    public void autoPark() {
        System.out.println("自动泊车");
    }

    @Override
    public void autoPilot() {
        System.out.println("无人驾驶");
    }
}
