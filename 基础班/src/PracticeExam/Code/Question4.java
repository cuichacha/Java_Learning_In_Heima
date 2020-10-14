package PracticeExam.Code;

import java.util.ArrayList;
import java.util.Random;

public final class Question4 {
    public static void main(String[] args) {
        Question4 question4 = new Question4();
        Student student1 = new Student("张三", question4.generateRandomScore(), question4.generateRandomScore());
        Student student2 = new Student("李四", question4.generateRandomScore(), question4.generateRandomScore());
        Student student3 = new Student("王五", question4.generateRandomScore(), question4.generateRandomScore());
        ArrayList<Student> arrayList= new ArrayList<>();
        ArrayList<Student> studentArrayList = new ArrayList<>();
        arrayList.add(student1);
        arrayList.add(student2);
        arrayList.add(student3);

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getChineseScore() + arrayList.get(i).getMathScore() > 160) {
                studentArrayList.add(arrayList.get(i));
            }
        }
        for (int i = 0; i < studentArrayList.size(); i++) {
            System.out.println(studentArrayList.get(i).getName() + "..."+
                    "语文成绩"+ studentArrayList.get(i).getChineseScore() + "..." +
                    "数学成绩" +studentArrayList.get(i).getMathScore());
        }
    }

    private int generateRandomScore() {
        Random random = new Random();
        int score = random.nextInt(101);
        return score;
    }

    static class Student {
        String name;
        int chineseScore;
        int mathScore;

        public Student() {
        }

        public Student(String name, int chineseScore, int mathScore) {
            this.name = name;
            this.chineseScore = chineseScore;
            this.mathScore = mathScore;
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

        public final void show() {
            System.out.println(getName() + "的语文成绩是" + getChineseScore());
            System.out.println(getName() + "的数学成绩是" + getMathScore());
        }
    }
}
