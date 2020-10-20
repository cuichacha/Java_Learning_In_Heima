package Day16.Code;

import java.lang.reflect.Field;

public class ReflectionDemo5 {
    public static void main(String[] args) {
        try {
            Demo5 demo5 = Demo5.class.getConstructor().newInstance();
            Field field = Demo5.class.getField("str");
            field.set(demo5, "lalala");
            System.out.println(field.get(demo5));
            // 此处打印出来为null，因为Demo5的对象不是同一个，这里一次性使用没有用引用，类似于匿名内部类
            System.out.println(Demo5.class.getField("str").get(Demo5.class.getConstructor().newInstance()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Demo5 demo5 = Demo5.class.getConstructor().newInstance();
            Field declaredField = Demo5.class.getDeclaredField("string");
            declaredField.setAccessible(true);
            declaredField.set(demo5, "dududu");
            System.out.println(declaredField.get(demo5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Demo5 {
    public Demo5() {
    }

    private String string;
    private int number;
    public String str;
    public int num;
}
