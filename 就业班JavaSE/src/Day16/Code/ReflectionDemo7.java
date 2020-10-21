package Day16.Code;

import java.lang.reflect.Method;

public class ReflectionDemo7 {
    public static void main(String[] args) {
        try {
            Method declaredMethod = Demo7.class.getDeclaredMethod("function4", String.class);
            Demo7 demo7 = Demo7.class.getConstructor().newInstance();
            System.out.println(declaredMethod.invoke(demo7, "lalala"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Method declaredMethod = Demo7.class.getDeclaredMethod("show");
            declaredMethod.setAccessible(true);
            Demo7 demo7 = Demo7.class.getConstructor().newInstance();
            System.out.println(declaredMethod.invoke(demo7));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Demo7 {
    public Demo7() {
    }

    //私有的，无参无返回值
    private void show() {
        System.out.println("私有的show方法，无参无返回值");
    }

    //公共的，无参无返回值
    public void function1() {
        System.out.println("function1方法，无参无返回值");
    }

    //公共的，有参无返回值
    public void function2(String name) {
        System.out.println("function2方法，有参无返回值,参数为" + name);
    }

    //公共的，无参有返回值
    public String function3() {
        System.out.println("function3方法，无参有返回值");
        return "aaa";
    }

    //公共的，有参有返回值
    public String function4(String name) {
        System.out.println("function4方法，有参有返回值,参数为" + name);
        return "aaa";
    }
}