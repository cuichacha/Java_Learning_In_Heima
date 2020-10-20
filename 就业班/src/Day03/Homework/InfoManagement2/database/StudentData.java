package Day03.Homework.InfoManagement2.database;

import Day03.Homework.InfoManagement2.domain.Student;

import java.util.ArrayList;

public final class StudentData extends PersonData {
    private ArrayList<Student> studentArrayList = new ArrayList<>();

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

}
