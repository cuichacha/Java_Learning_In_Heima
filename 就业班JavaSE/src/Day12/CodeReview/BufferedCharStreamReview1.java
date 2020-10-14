package Day12.CodeReview;

import java.io.*;

public class BufferedCharStreamReview1 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String str;

        try {
            bufferedReader = new BufferedReader(new FileReader("/Users/willdufresne/Downloads/a.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("/Users/willdufresne/Movies/a.txt"));
            while ((str = bufferedReader.readLine()) != null) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
