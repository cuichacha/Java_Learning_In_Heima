package Question19;

import java.util.ArrayList;

public class wanxing {
    public static void main(String[] args) {
        //分别实例化四个Singer对象，
        Singer s1 = new Singer("郭富城", 55, "踢足球");
        Singer s2 = new Singer("张学友", 35, "游泳");
        Singer s3 = new Singer("刘德华", 25, "打篮球");
        Singer s4 = new Singer("黎明", 18, "击剑");
        //创建一个ArrayList集合，这个集合里面存储的是Singer类型，分别将上面的四个Singer对象添加到集合中
        ArrayList<Singer> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        //遍历集合，如果集合中对象的年龄大于30，将这个对象的爱好改成”打保龄球”
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAge() > 30) {
                list.get(i).setLike("打保龄球");
            }
        }
        //遍历集合,如果对象的年龄小于30，那么就把这个对象删除
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).getAge() < 30) {
                list.remove(i);
            }
        }
        //打印修改后集合里面全部对象所有的属性信息到控制台。
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + list.get(i).getAge() + list.get(i).getLike());
        }
    }
}

//定义"歌手"类,Singer
class Singer {
    // 成员属性: name (姓名):String类型，age (年龄):int类型，like (爱好):String类型，属性必须使用private修饰。
    // 成员方法：有参构造方法
    private String name;
    private int age;
    private String like;

    public Singer() {
    }

    public Singer(String name, int age, String like) {
        this.name = name;
        this.age = age;
        this.like = like;
    }

    //3个属性的get/set方法
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

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}