package Day12.Code;

import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo2 {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        char[] chars = {97, 98, 99, 100, 101, 102};
        String str = "啦啦啦啦啦";

        try {
            fileWriter = new FileWriter("/Users/willdufresne/Downloads/a.txt", true);
            fileWriter.write(97);
            fileWriter.write("\r");
            fileWriter.write(chars);
            fileWriter.write("\r");
            fileWriter.write(chars, 0, 3);
            fileWriter.write("\r");
            fileWriter.write(str);
            fileWriter.write("\r");
            fileWriter.write(str, 0, 3);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
