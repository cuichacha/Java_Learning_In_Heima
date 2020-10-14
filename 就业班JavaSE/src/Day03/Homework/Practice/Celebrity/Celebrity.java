package Day03.Homework.Practice.Celebrity;

public class Celebrity {
    String name;
    String age;

    public Celebrity(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("我是明星" + name + "，今年" + age + "岁");
    }
}
