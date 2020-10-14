package Day12.Code;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo3 {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        FileReader fileReader = null;
        char[] chars = new char[1024];

        try {
            fileReader = new FileReader("/Users/willdufresne/Downloads/a.txt");
            fileWriter = new FileWriter("/Users/willdufresne/Movies/a.txt");
            int len;
            while ((len = fileReader.read(chars)) != -1) {
                fileWriter.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader!= null && fileWriter != null) {
                try {
                    fileReader.close();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
