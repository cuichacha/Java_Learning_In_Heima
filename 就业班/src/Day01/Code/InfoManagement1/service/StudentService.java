package Day01.Code.InfoManagement1.service;

import Day01.Code.InfoManagement1.dao.StudentDao;
import Day01.Code.InfoManagement1.domain.Student;

public class StudentService {
    private StudentDao studentDao = new StudentDao();
    private Student[] students = studentDao.getStudents();

    public void addStudent(Student student) {
        if (studentDao.invokeAddStudent(student)) {
            System.out.println("添加成功");
        } else {
            System.out.println("数据库已满，添加失败");
        }
    }

    public int isExisted(String id) {
        return studentDao.invokeIsExisted(id);
    }


    public void deleteStudent(String id) {
        if (studentDao.invokeDeleteStudent(id)) {
            System.out.println("删除成功");
        }
    }

    public void editStudent(String id, String choice, String info) {
        studentDao.invokeEditStudent(id, choice, info);
        System.out.println("修改成功");
    }


    private boolean isEmpty() {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                return false;
            }
        }
        return true;
    }

    public boolean invokeIsEmpty() {
        return isEmpty();
    }

    public void showStudent() {
        System.out.println("学号\t\t姓名\t\t年龄\t\t生日");
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.println(students[i].getId() + "\t\t" + students[i].getName() +
                        "\t\t" + students[i].getAge() + "\t\t" + students[i].getBirthday());
            }
        }
    }

}