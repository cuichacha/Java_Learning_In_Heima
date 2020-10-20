package Day16.Code;

import java.lang.reflect.Constructor;

public class ReflectionDemo2 {
    public static void main(String[] args) {
        for (Constructor<?> constructor : Demo2.class.getConstructors()) {
            System.out.println(constructor);
        }

        System.out.println("-----------------------------");

        for (Constructor<?> declaredConstructor : Demo2.class.getDeclaredConstructors()) {
            System.out.println(declaredConstructor);
        }

        System.out.println("-----------------------------");

        try {
            System.out.println(Demo2.class.getConstructor());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------------------");

        try {
            System.out.println(Demo2.class.getDeclaredConstructor(int.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------------------");

        try {
            System.out.println(Demo2.class.getDeclaredConstructor());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------------------");

        // declare可以访问public，普通不能访问private！！

//        try {
//            System.out.println(Demo2.class.getConstructor(String.class));
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
    }
}

class Demo2 {
    private String str;
    private int num;

    public Demo2() {
    }

    private Demo2(String str) {
        this.str = str;
    }

    private Demo2(int num) {
        this.num = num;
    }

    public Demo2(String str, int num) {
        this.str = str;
        this.num = num;
    }
}