package Day01.Code.InfoManagement1.service;

import Day01.Code.InfoManagement1.dao.TeacherDao;
import Day01.Code.InfoManagement1.domain.Teacher;

public class TeacherService {
    TeacherDao teacherDao = new TeacherDao();
    Teacher[] teachers = teacherDao.getTeachers();

    private boolean addTeacher(Teacher teacher) {
        if (teacherDao.invokeIsFull()) {
            return false;
        } else {
            return teacherDao.invokeAddTeacher(teacher);
        }
    }

    public boolean invokeAddTeacher(Teacher teacher) {
        return addTeacher(teacher);
    }

    public int isExisted(String id) {
        return teacherDao.invokeIsExisted(id);
    }

    private boolean showTeacher() {
        if (teacherDao.invokeIsEmpty()) {
            return true;
        } else {
            System.out.println("工号\t\t姓名\t\t年龄\t\t生日");
            for (int i = 0; i < teachers.length; i++) {
                if (teachers[i] != null) {

                    System.out.println(teachers[i].getId() + "\t\t" + teachers[i].getName() +
                            "\t\t" + teachers[i].getAge() + "\t\t" + teachers[i].getBirthday());
                }
            }
            return false;
        }
    }

    public boolean invokeShowTeacher() {
        return showTeacher();
    }

    private boolean deleteTeacher(String id) {
        if (isExisted(id) == -1) {
            return false;
        } else {
            teacherDao.invokeDeleteTeacher(id);
        }
        return true;
    }

    public boolean invokeDeleteTeacher(String id) {
        return deleteTeacher(id);
    }

    public boolean editTeacher(String id, String choice, String info) {
        return teacherDao.invokeEditTeacher(id, choice, info);
    }
}
