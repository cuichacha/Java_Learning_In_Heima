package Day16.CodeReview;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        try {
            Class<?> clazz = Class.forName(className);
            Object o = clazz.getConstructor().newInstance();
            Method method = clazz.getDeclaredMethod(methodName);
            method.setAccessible(true);
            method.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}