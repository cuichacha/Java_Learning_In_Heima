package Day12.Code;

import java.io.*;

public class BufferedCharStreamDemo1 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String str;

        try {
            bufferedReader = new BufferedReader(new FileReader("/Users/willdufresne/Downloads/a.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("/Users/willdufresne/Movies/a.txt"));
//            for (int i = 0; i < 5; i++) {
//                bufferedWriter.write("啦啦啦");
//                bufferedWriter.newLine();
//            }

            while ((str = bufferedReader.readLine()) != null) {
                bufferedWriter.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null && bufferedWriter != null) {
                try {
                    bufferedReader.close();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
