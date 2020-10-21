package Day11.CodeReview;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileReview3 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
//        File file = new File("/Users/willdufresne/Downloads/a.txt");
        File file = new File("/Users/willdufresne/Downloads/");
        System.out.println(getCount(map, file));
    }

    private static Map<String, Integer> getCount(Map<String, Integer> map, File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File insideFile : files) {
                if (insideFile.isFile()) {
                    String[] fileName = insideFile.getName().split("\\.");
                    String suffix = fileName[fileName.length - 1];
                    if (map.containsKey(suffix)) {
                        map.put(suffix, map.get(suffix) + 1);
                    } else {
                        map.put(suffix, 1);
                    }
                } else {
                    getCount(map, insideFile);
                }
            }
            return map;
        } else {
            System.out.println("路径指向非文件内容");
        }
        return null;
    }
}
