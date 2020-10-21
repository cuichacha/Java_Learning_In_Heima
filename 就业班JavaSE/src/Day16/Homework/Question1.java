package Day16.Homework;

public class Question1 {
    public static void main(String[] args) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("Day16.Homework.Student");
            Object o = clazz.newInstance();
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Class<Student> studentClass = Student.class;
        try {
            System.out.println(studentClass.getConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Student {
    public Student() {
    }

    @Override
    public String toString() {
        return "Student{}";
    }
}