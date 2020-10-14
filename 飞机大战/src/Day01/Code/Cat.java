package Day01.Code;

public class Cat extends Animal {
    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    public void catchMice() {
        System.out.println("抓老鼠");
    }
}
