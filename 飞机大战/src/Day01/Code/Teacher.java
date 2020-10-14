package Day01.Code;

public class Teacher extends Human {
    public Teacher() {
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public void teach() {
        System.out.println("上课");
    }
}
