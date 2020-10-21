package Day03.Homework.Practice.Celebrity;

public class SubCelebrity extends Celebrity {

    public SubCelebrity(String name, String age) {
        super(name, age);
    }

    @Override
    public void introduce() {
        System.out.println("我是明星子类" + name + "，今年" + age + "岁");
    }

    public void dance() {
        System.out.println("我是明星子类，我跳拉丁舞。。。。。。");
    }
}
