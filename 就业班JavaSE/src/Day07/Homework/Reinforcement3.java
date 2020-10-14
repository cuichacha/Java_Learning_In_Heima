package Day07.Homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Reinforcement3 {
    public static void main(String[] args) {
        ArrayList<Students> arrayList = new ArrayList<>();
        arrayList.add(new Students("1", 1, "1"));
        arrayList.add(new Students("2", 2, "0"));
        arrayList.add(new Students("3", 3, "1"));
        int maxAge = -1;
        int index = -1;

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getAge() >= maxAge) {
                maxAge = arrayList.get(i).getAge();
                index = i;
            }
        }
        arrayList.get(index).setName("小猪佩奇");
        System.out.println(Arrays.toString(arrayList.toArray(arrayList.toArray(new Students[arrayList.size()]))));

        for (Students students : arrayList) {
            if (students.getAge() >= maxAge) {
                maxAge = students.getAge();
                index = arrayList.indexOf(students);
            }
        }

        arrayList.get(index).setName("111");
        System.out.println(Arrays.toString(arrayList.toArray(arrayList.toArray(new Students[arrayList.size()]))));

    }
}

class Students {
    private String name;
    private int age;
    private String gender;

    public Students() {
    }

    public Students(String name, int age, String gender) {
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
