package Day09.Homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class Question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            System.out.println("请输入学生信息");
            String student = scanner.nextLine();
            String name = student.split(",")[0];
            String age = student.split(",")[1];
            map.put(name, age);
        }
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String name, String age) {
                System.out.println(name + "--" + age);
            }
        });
    }
}
