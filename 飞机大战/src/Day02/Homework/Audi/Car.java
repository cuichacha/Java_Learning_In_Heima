package Day02.Homework.Audi;

public abstract class Car {
    private String model;

    public Car() {
    }

    public Car(String model) {
        this.model = model;
    }

    public abstract void run();
}
