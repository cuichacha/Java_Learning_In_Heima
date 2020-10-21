package Day07.Homework;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class Reinforcement6 {
    LinkedList<Human> linkedList = new LinkedList<>();

    private boolean isExisted(Human findHuman) {
        for (Human human : linkedList) {
            if (findHuman.equals(human)) {
                return true;
            }
        }
        return false;
    }

    public void add(Human human) {
        if (isExisted(human)) {
            System.out.println("已存在，无法添加");
        } else {
            linkedList.add(human);
        }
    }

}

class Test2 {

    public static void main(String[] args) {
        Reinforcement6 reinforcement6 = new Reinforcement6();
        Human human1 = new Human("1", 1);
        Human human2 = new Human("1", 1);
        Human human3 = new Human("3", 3);



        reinforcement6.add(human1);
        reinforcement6.add(human2);
        reinforcement6.add(human3);

        System.out.println(Arrays.toString(reinforcement6.linkedList.toArray(new Human[reinforcement6.linkedList.size()])));
    }
}

class Human {
    private String name;
    private int age;

    public Human() {
    }

    public Human(String name, int age) {
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
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}