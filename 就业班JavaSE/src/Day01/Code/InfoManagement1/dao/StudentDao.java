package Day01.Code.InfoManagement1.dao;

import Day01.Code.InfoManagement1.domain.Student;

public class StudentDao {
    private Student[] students = new Student[5];

    public Student[] getStudents() {
        return students;
    }

    private boolean addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return true;
            }
        }
        return false;
    }

    public boolean invokeAddStudent(Student student) {
        return addStudent(student);
    }

    private int isExisted(String id) {
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && id.equals(students[i].getId())) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public int invokeIsExisted(String id) {
        return isExisted(id);
    }

    private boolean deleteStudent(String id) {
        for (int i = 0; i < students.length; i++) {
            if (id.equals(students[i].getId())) {
                students[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean invokeDeleteStudent(String id) {
        return deleteStudent(id);
    }

    private void editStudent(String id, String choice, String info) {
        int index = isExisted(id);
        if (choice.equals("1")) {
            students[index].setName(info);
        }
        if (choice.equals("2")) {
            students[index].setAge(info);
        }
        if (choice.equals("3")) {
            students[index].setBirthday(info);
        }
    }

    public void invokeEditStudent(String id, String choice, String info) {
        editStudent(id, choice, info);
    }

}
