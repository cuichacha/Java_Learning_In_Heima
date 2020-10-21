package Day16.Code;

import java.lang.reflect.Method;

public class ReflectionDemo6 {
    public static void main(String[] args) {
        for (Method method : Demo6.class.getMethods()) {
            System.out.println(method);
        }
        System.out.println("-----------------------------");
        for (Method declaredMethod : Demo6.class.getDeclaredMethods()) {
            System.out.println(declaredMethod);
        }
        System.out.println("-----------------------------");
        try {
            System.out.println(Demo6.class.getMethod("function1"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------");
        try {
            System.out.println(Demo6.class.getDeclaredMethod("function4", String.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

class Demo6 {
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
