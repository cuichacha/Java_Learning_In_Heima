package Day16.Homework;

import java.lang.reflect.Method;

public class Question4 {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("Day16.Homework.Person");
            Object o = clazz.getConstructor().newInstance();
            Method setName = clazz.getMethod("setName", String.class);
            setName.invoke(o, "lala");
            Method setAge = clazz.getMethod("setAge", int.class);
            setAge.invoke(o, 5);
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Person {
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