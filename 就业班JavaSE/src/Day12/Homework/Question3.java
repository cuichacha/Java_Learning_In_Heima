package Day12.Homework;

import java.io.*;

public class Question3 {
    public static void main(String[] args) {
        Person person1 = new Person("1", 1, "1");
        Person person2 = new Person("2", 2, "2");
        Person person3 = new Person("3", 3, "3");

        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/willdufresne/Downloads/a_copy.txt"));
            objectOutputStream.writeObject(person1);
            objectOutputStream.writeObject(person2);
            objectOutputStream.writeObject(person3);
            objectOutputStream.flush();

            objectInputStream = new ObjectInputStream(new FileInputStream("/Users/willdufresne/Downloads/a_copy.txt"));

            while (true) {
                try {
                    Object o = objectInputStream.readObject();
                    Person person = (Person) o;
                    System.out.println(person);
                } catch (IOException | ClassNotFoundException e) {
//                        e.printStackTrace();
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

class Person implements Serializable{
    private String name;
    private int age;
    private String gender;

    public Person() {
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
