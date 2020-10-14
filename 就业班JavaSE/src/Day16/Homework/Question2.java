package Day16.Homework;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Question2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Class<? extends ArrayList> clazz = list.getClass();
        try {
            Method add = clazz.getMethod("add", Object.class);
            add.invoke(list, "哈哈哈");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
