package Day12.CodeReview;

import java.io.*;

public class ObjectStreamReview2 {
    public static void main(String[] args) {
        Student student1 = new Student("1", 1);
        Student student2 = new Student("2", 2);
        Student student3 = new Student("3", 3);

        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/willdufresne/Downloads/c.txt"));
            objectOutputStream.writeObject(student1);
            objectOutputStream.writeObject(student2);
            objectOutputStream.writeObject(student3);
            objectInputStream = new ObjectInputStream(new FileInputStream("/Users/willdufresne/Downloads/c.txt"));
            while (true) {
                try {
                    Object o = objectInputStream.readObject();
                    Student student = (Student) o;
                    System.out.println(student);
                } catch (IOException | ClassNotFoundException e) {
//                    e.printStackTrace();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Student implements Serializable {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
