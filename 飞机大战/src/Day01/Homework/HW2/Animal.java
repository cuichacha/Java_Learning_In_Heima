package Day01.Homework.HW2;

public abstract class Animal {
    private int age;
    private String gender;

    public Animal() {
    }

    public Animal(int age, String gender) {
        this.age = age;
        this.gender = gender;
    }

    public abstract void eat();

    public abstract void sleep();

    public abstract void move();
}
