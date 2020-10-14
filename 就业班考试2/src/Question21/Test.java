package Question21;

import java.io.File;
import java.util.TreeSet;

public final class Test {
    public static void main(String[] args) {
        InputAndShowScores inputAndShowScores = new InputAndShowScores();
        TreeSet<Student> studentTreeSet = inputAndShowScores.getStudentTreeSet();
        TreeSet<Student> students = inputAndShowScores.inputInfo(studentTreeSet);
        File file = inputAndShowScores.writeToFile(students);
        inputAndShowScores.readFile(file);
    }
}
