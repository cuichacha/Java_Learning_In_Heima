package Day16.Code;

import java.lang.reflect.Constructor;

public class ReflectionDemo3 {
    public static void main(String[] args) {
        try {
            System.out.println(Demo3.class.getConstructor(String.class, int.class).newInstance("lalala", 5));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Constructor<Demo3> declaredConstructor = Demo3.class.getDeclaredConstructor(String.class);
            declaredConstructor.setAccessible(true);
            System.out.println(declaredConstructor.newInstance("dududu"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Demo3 {
    private String str;
    private int num;

    public Demo3() {
    }

    private Demo3(String str) {
        this.str = str;
    }

    private Demo3(int num) {
        this.num = num;
    }

    public Demo3(String str, int num) {
        this.str = str;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Demo3{" +
                "str='" + str + '\'' +
                ", num=" + num +
                '}';
    }
}