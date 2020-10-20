package Day05.CodeReview;

import java.util.Objects;

public class ObjectReview {
    public static void main(String[] args) {
        Human human1 = new Human("啦啦", 0);
        System.out.println(human1);

        Human human2 = new Human("啦啦", 0);
        System.out.println(human1.equals(human2));

        String str1 = new String("aaaa");
        String str2 = new String("aaaa");
        StringBuilder stringBuilder = new StringBuilder(str1);

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
//        System.out.println(str1 == stringBuilder);
        System.out.println(str1.equals(stringBuilder));
        System.out.println(stringBuilder.equals(str1));
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
