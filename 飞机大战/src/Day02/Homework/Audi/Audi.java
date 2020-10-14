package Day02.Homework.Audi;

public class Audi extends Car {
    public Audi() {
    }

    public Audi(String model) {
        super(model);
    }

    @Override
    public void run() {
        System.out.println("开奥迪车");
    }
}
