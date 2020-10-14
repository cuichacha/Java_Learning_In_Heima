package Day11.Code;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FileDemo7 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("/Users/willdufresne/Downloads");
        File file2 = new File("/Users/willdufresne/Downloads/a.txt");
        file2.createNewFile();
        HashMap<String, Integer> hashMap = new HashMap<>();
        System.out.println(getCount(hashMap, file1));
    }

    private static HashMap<String, Integer> getCount(HashMap<String, Integer> hashMap, File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File insideFiles : files) {
                if (insideFiles.isFile()) {
                    String[] name = insideFiles.getName().split("\\.");
                    String suffix = name[name.length - 1];
                    if (hashMap.containsKey(suffix)) {
                        hashMap.put(suffix, hashMap.get(suffix) + 1);
                    } else {
                        hashMap.put(suffix, 1);
                    }
                } else {
                    getCount(hashMap, insideFiles);
                }
            }
            return hashMap;
        } else {
            System.out.println("指定目录非文件夹");
            return null;
        }
    }
}
