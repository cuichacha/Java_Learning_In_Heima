package Day12.CodeReview;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ObjectStreamReview3 {
    public static void main(String[] args) {
        Person person1 = new Person("1", 1);
        Person person2 = new Person("2", 2);
        Person person3 = new Person("3", 3);
        List<Person> list = new ArrayList<>(List.of(person1, person2, person3));

        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/willdufresne/Downloads/c.txt"));
            objectOutputStream.writeObject(list);

            objectInputStream = new ObjectInputStream(new FileInputStream("/Users/willdufresne/Downloads/c.txt"));
            Object o = objectInputStream.readObject();
            List<Person> readList = (List<Person>) o;
            readList.forEach(new Consumer<Person>() {
                @Override
                public void accept(Person person) {
                    System.out.println(person.getName() + "--" + person.getAge());
                }
            });
        } catch (IOException | ClassNotFoundException e) {
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

class Person implements Serializable {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}