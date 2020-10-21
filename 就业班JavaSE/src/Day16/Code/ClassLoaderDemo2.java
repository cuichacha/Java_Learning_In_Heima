package Day16.Code;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderDemo2 {
    public static void main(String[] args) {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("prop.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            System.out.println(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
