package Day09.Code;

import java.util.ArrayList;

public final class Day09_Code5 {

    public static void main(String[] args) {
        Day09_Code5 day09_code5 = new Day09_Code5();
        day09_code5.wrongRemoval();
        System.out.println("------------------");
        day09_code5.correctRemoval();
    }

    private void wrongRemoval() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("11");
        stringArrayList.add("22");
        stringArrayList.add("22");
        stringArrayList.add("11");
        stringArrayList.add("11");

        for (int i = 0; i < stringArrayList.size(); i++) {
            String str = "11";
            if (str.equals(stringArrayList.get(i))) {
                stringArrayList.remove(i);
            }
        }
        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.println(stringArrayList.get(i));
        }
    }

    private void correctRemoval() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("11");
        stringArrayList.add("22");
        stringArrayList.add("22");
        stringArrayList.add("11");
        stringArrayList.add("11");

        for (int i = stringArrayList.size() - 1; i >= 0; i--) {
            String str = "11";
            if (str.equals(stringArrayList.get(i))) {
                stringArrayList.remove(i);
            }
        }
        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.println(stringArrayList.get(i));
        }
    }
}
