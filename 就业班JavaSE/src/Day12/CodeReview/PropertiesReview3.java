package Day12.CodeReview;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReview3 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("1", "1");
        properties.put("2", "2");
        properties.put("3", "3");
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter("/Users/willdufresne/Downloads/prop.properties"));
            properties.store(bufferedWriter, "啦啦啦");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
