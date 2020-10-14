package Day01.Code;

public class Student extends Human {
    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    public void study() {
        System.out.println("学习");
    }
}
