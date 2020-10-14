package Day16.Homework;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Question5 {
    public static void main(String[] args) {
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("democlass.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            String className = properties.getProperty("className");
            String methodName = properties.getProperty("methodName");
            Class<?> clazz = Class.forName(className);
            Object o = clazz.getConstructor().newInstance();
            Method declaredMethod = clazz.getDeclaredMethod(methodName);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DemoClass {
    public DemoClass() {
    }

    private void run() {
        System.out.println("welcome to the jungle!!");
    }
}
