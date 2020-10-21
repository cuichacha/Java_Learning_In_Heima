package Day12.CodeReview;

import java.util.Properties;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class PropertiesReview1 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("1", "1");
        properties.put("2", "2");
        properties.put("3", "3");

        properties.forEach(new BiConsumer<Object, Object>() {
            @Override
            public void accept(Object o, Object o2) {
                System.out.println(o + "--" + o2);
            }
        });

        properties.setProperty("1", "9");
        properties.setProperty("2", "8");
        properties.setProperty("3", "7");

        System.out.println(properties.getProperty("1"));

        Set<String> keys = properties.stringPropertyNames();
        keys.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s + "--" + properties.getProperty(s));
            }
        });
    }
}
