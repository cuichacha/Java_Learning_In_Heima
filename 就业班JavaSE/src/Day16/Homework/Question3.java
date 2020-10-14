package Day16.Homework;

import java.lang.reflect.Method;

public class Question3 {
    public static void main(String[] args) {
        Class<Demo> clazz = Demo.class;
        try {
            Demo demo = clazz.getConstructor().newInstance();
            Method declaredMethod = clazz.getDeclaredMethod("show");
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(demo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Demo {
    public Demo() {
    }

    private void show() {
        System.out.println("啦啦啦");
    }
}