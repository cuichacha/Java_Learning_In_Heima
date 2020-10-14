package Day09.Code;

import java.util.ArrayList;

public final class Day09_Code2 {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();

        String str1 = "zhangsan";
        String str2 = "lisi";
        String str3 = "wangwu";
        String str4 = "zhaoliu";
        String str5 = "zhouqi";

        stringArrayList.add(str1);
        stringArrayList.add(str2);
        stringArrayList.add(str3);
        stringArrayList.add(str4);
        stringArrayList.add(str5);

        stringArrayList.remove("lisi");
        stringArrayList.remove(3);
        stringArrayList.set(2, "zl");
        System.out.println(stringArrayList.size());

        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.println(stringArrayList.get(i));
        }
    }
}
