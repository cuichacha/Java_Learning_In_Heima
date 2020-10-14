package Question21;

import java.io.*;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public final class InputAndShowScores {

    private TreeSet<Student> studentTreeSet = new TreeSet<>(new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            int result = (o2.getChineseScore() + o2.getMathScore() + o2.getEnglishScore()) -
                    (o1.getChineseScore() + o1.getMathScore() + o1.getEnglishScore());
            result = result == 0 ? o2.getName().compareTo(o1.getName()) : result;
            return result;
        }
    });

    public TreeSet<Student> getStudentTreeSet() {
        return studentTreeSet;
    }

    public TreeSet<Student> inputInfo(TreeSet<Student> studentTreeSet) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.println("请输入第" + i + "个学生信息：");
            String name = scanner.nextLine();
            String chineseGrades;
            while (true) {
                System.out.println("语文成绩：");
                chineseGrades = scanner.nextLine();
                if (checkInput(chineseGrades)) {
                    break;
                } else {
                    System.out.println("您输入的成绩有误，请输入正确格式的整数");
                }
            }
            int chineseScore = Integer.parseInt(chineseGrades);
            String mathGrades;
            while (true) {
                System.out.println("数学成绩：");
                mathGrades = scanner.nextLine();
                if (checkInput(mathGrades)) {
                    break;
                } else {
                    System.out.println("您输入的成绩有误，请输入正确格式的整数");
                }
            }
            int mathScore = Integer.parseInt(mathGrades);
            String englishGrades;
            while (true) {
                System.out.println("英语成绩：");
                englishGrades = scanner.nextLine();
                if (checkInput(englishGrades)) {
                    break;
                } else {
                    System.out.println("您输入的成绩有误，请输入正确格式的整数");
                }
            }
            int englishScore = Integer.parseInt(englishGrades);
            Student student = new Student(name, chineseScore, mathScore, englishScore);
            studentTreeSet.add(student);
        }
        return studentTreeSet;
    }

    private boolean checkInput(String str) {

        try {
            int score = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
//                e.printStackTrace();
            return false;
        }

    }

    public File writeToFile(TreeSet<Student> studentTreeSet) {
        File file = new File("/Users/willdufresne/Documents/黑马Java/就业班考试2/src/Question21/StudentsInfo.txt");
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Student student : studentTreeSet) {
                bufferedWriter.write(student.getName());
                bufferedWriter.write(",");
                int chineseScore = student.getChineseScore();
                bufferedWriter.write(String.valueOf(chineseScore));
                bufferedWriter.write(",");
                int mathScore = student.getMathScore();
                bufferedWriter.write(String.valueOf(mathScore));
                bufferedWriter.write(",");
                int englishScore = student.getEnglishScore();
                bufferedWriter.write(String.valueOf(englishScore));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

    public void readFile(File file) {
        BufferedReader bufferedReader = null;
        String str;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}


