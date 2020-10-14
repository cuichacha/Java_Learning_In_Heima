package Day16.CodeReview;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionReview {
    public static void main(String[] args) {
//        operateConstructors();
//        operateFields();
        operateMethods();
    }

    private static void operateConstructors() {
        for (Constructor<?> constructor : Demo.class.getConstructors()) {
            System.out.println(constructor);
        }
        System.out.println("-------------------------------------");
        for (Constructor<?> declaredConstructor : Demo.class.getDeclaredConstructors()) {
            System.out.println(declaredConstructor);
        }
        System.out.println("-------------------------------------");
        try {
            System.out.println(Demo.class.getConstructor(int.class, int.class).newInstance(5, 5));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Constructor<Demo> declaredConstructor = Demo.class.getDeclaredConstructor(String.class, int.class);
            declaredConstructor.setAccessible(true);
            System.out.println(declaredConstructor.newInstance("dudu", 5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void operateFields() {
        for (Field field : Demo.class.getFields()) {
            System.out.println(field);
        }
        System.out.println("-------------------------------------");
        for (Field declaredField : Demo.class.getDeclaredFields()) {
            System.out.println(declaredField);
        }
        System.out.println("-------------------------------------");
        try {
            Field field = Demo.class.getField("str");
            Demo demo = Demo.class.getConstructor().newInstance();
            field.set(demo, "lalala");
            System.out.println(field.get(demo));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------------------");
        try {
            Field field = Demo.class.getDeclaredField("string");
            field.setAccessible(true);
            Demo demo = Demo.class.getConstructor().newInstance();
            field.set(demo, "dududu");
            System.out.println(field.get(demo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void operateMethods() {
        for (Method method : Demo.class.getMethods()) {
            System.out.println(method);
        }
        System.out.println("-------------------------------------");
        for (Method declaredMethod : Demo.class.getDeclaredMethods()) {
            System.out.println(declaredMethod);
        }
        System.out.println("-------------------------------------");
        try {
            Method method = Demo.class.getMethod("function4", String.class);
            Demo demo = Demo.class.getConstructor(int.class, int.class).newInstance(5, 5);
            System.out.println(method.invoke(demo, "hahaha"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------------------");
        try {
            Method method = Demo.class.getDeclaredMethod("function2", String.class);
            Constructor<Demo> constructor = Demo.class.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            Demo demo = constructor.newInstance("hohoho", 5);
            method.setAccessible(true);
            System.out.println(method.invoke(demo, "hohoho"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Demo {
    private String string;
    private int number;
    public String str;
    public int num;

    public Demo() {
    }

    private Demo(String str) {
        this.str = str;
    }

    private Demo(String string, int num) {
        this.string = string;
        this.num = num;
    }

    public Demo(int number, int num) {
        this.number = number;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "string='" + string + '\'' +
                ", number=" + number +
                ", str='" + str + '\'' +
                ", num=" + num +
                '}';
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
    private void function2(String name) {
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