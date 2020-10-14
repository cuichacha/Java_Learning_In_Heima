package PracticeExam.Code;

import java.util.Scanner;

public final class Exam_3_2 {
    /*
          1.C 2.C 3.C 4.B 5.C 6.B 7.C 8.B 9.A 10.D
          11.ABD 12.ACD 13.ABC 14.AB 15.AB 16.ACD 17.ABD
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串");
        String str = scanner.nextLine();
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                newStr += str.charAt(i);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                newStr += str.charAt(i);
            }
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                newStr += str.charAt(i);
            }
        }
        System.out.println(newStr);
    }
}
