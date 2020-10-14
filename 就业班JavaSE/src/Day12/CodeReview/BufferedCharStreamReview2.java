package Day12.CodeReview;

import java.io.*;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

public class BufferedCharStreamReview2 {

    /*
        在一个文件内随机生成十行字符串形式的数字，以空格隔开
        把文件内容进行排序（从小到大），写入另一个文件中
     */

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String str;
        Random random = new Random();

        try {
            bufferedWriter = new BufferedWriter(new FileWriter("/Users/willdufresne/Downloads/a.txt"));
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    int randomNumber = random.nextInt(100);
                    bufferedWriter.write(Integer.toString(randomNumber));
                    bufferedWriter.write(" ");
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();

            bufferedReader = new BufferedReader(new FileReader("/Users/willdufresne/Downloads/a.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("/Users/willdufresne/Movies/a.txt"));
            while ((str = bufferedReader.readLine()) != null) {
                String[] numbers = str.split(" ");
                BufferedWriter finalBufferedWriter = bufferedWriter;

                // 使用匿名内部类形式
//                Stream.of(numbers).sorted(new Comparator<String>() {
//                    @Override
//                    public int compare(String o1, String o2) {
//                        return Integer.parseInt(o1) - Integer.parseInt(o2);
//                    }
//                }).forEach(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) {
//                        try {
//                            finalBufferedWriter.write(s + " ");
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });

                // 使用Lambda表达式
                Stream.of(numbers).sorted(Comparator.comparingInt(Integer::parseInt)).
                        forEach((number) -> {
                            try {
                                finalBufferedWriter.write(number + " ");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });

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
