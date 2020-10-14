package Day08.Homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Question2 {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int num = random.nextInt(33) + 1;
            if (!set.contains(num)) {
                set.add(num);
            } else {
                i--;
            }
        }

        int num = random.nextInt(16) + 1;
        set.add(num);

        System.out.println(Arrays.toString(set.toArray(new Integer[set.size()])));
    }

}
