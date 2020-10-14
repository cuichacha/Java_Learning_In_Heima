package Day09.Code;

import java.util.Comparator;
import java.util.TreeSet;

public class RedAndBlackTreeDemo {
    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = o1.getSum() - o2.getSum();
                result = result == 0 ? o1.getChineseScore() - o2.getChineseScore() : result;
                result = result == 0 ? o1.getMathScore() - o2.getMathScore() : result;
                result = result == 0 ? o1.getEnglishScore() - o2.getEnglishScore() : result;
                result = result == 0 ? o1.getName().compareTo(o2.getName()) : result;
                return result;
            }
        });

        Student student1 = new Student("11", 11, 11, 11);
        Student student2 = new Student("22", 22, 22, 22);
        Student student3 = new Student("33", 33, 33, 33);
        Student student4 = new Student("44", 11, 11, 11);


        treeSet.add(student1);
        treeSet.add(student2);
        treeSet.add(student3);
        treeSet.add(student4);

        System.out.println(treeSet);
    }
}

class Student {
    private String name;
    private int chineseScore;
    private int mathScore;
    private int englishScore;

    public Student() {
    }

    public Student(String name, int chineseScore, int mathScore, int englishScore) {
        this.name = name;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(int chineseScore) {
        this.chineseScore = chineseScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", chineseScore=" + chineseScore +
                ", mathScore=" + mathScore +
                ", englishScore=" + englishScore +
                '}';
    }

    public int getSum() {
        return chineseScore + mathScore + englishScore;
    }
}
