package Day12.CodeReview;

import java.io.FileWriter;
import java.io.IOException;

public class CharStreamReview2 {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        String str = "叽里呱啦";
        char[] chars = {98, 99, 100, 101};

        try {
            fileWriter = new FileWriter("/Users/willdufresne/Downloads/a.txt");
            fileWriter.write(97);
            fileWriter.write("\n");
            fileWriter.write(chars);
            fileWriter.write("\n");
            fileWriter.write(chars, 1, 2);
            fileWriter.write("\n");
            fileWriter.write(str);
            fileWriter.write("\n");
            fileWriter.write(str, 1, 2);
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
