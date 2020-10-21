package Day16.Code;

import java.lang.reflect.Field;

public class ReflectionDemo4 {
    public static void main(String[] args) {
        for (Field field : Demo4.class.getFields()) {
            System.out.println(field);
        }
        System.out.println("-----------------------------");
        for (Field declaredField : Demo4.class.getDeclaredFields()) {
            System.out.println(declaredField);
        }
        System.out.println("-----------------------------");
        try {
            System.out.println(Demo4.class.getField("num"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------");
        try {
            System.out.println(Demo4.class.getDeclaredField("string"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

class Demo4 {
    private String string;
    private int number;
    public String str;
    public int num;


}
