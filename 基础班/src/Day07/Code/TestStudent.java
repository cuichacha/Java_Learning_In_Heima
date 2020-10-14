package Day07.Code;

public final class TestStudent {

    public static void main(String[] args) {
        Student student = new Student("无名", 55, "男");

        String name;
        int age;
        String gender;

        name = student.getName();
        age = student.getAge();
        gender = student.getGender();

        System.out.println(name + " " + age + " " + gender);
        student.eat();
        student.sleep();
    }
}
