package Day01.Code.InfoManagement1.dao;

import Day01.Code.InfoManagement1.domain.Teacher;

public class TeacherDao {
    private Teacher[] teachers = new Teacher[5];

    public Teacher[] getTeachers() {
        return teachers;
    }

    private boolean addTeacher(Teacher teacher) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                teachers[i] = teacher;
                return true;
            }
        }
        return false;
    }

    public boolean invokeAddTeacher(Teacher teacher) {
        return addTeacher(teacher);
    }

    private int isExisted(String id) {
        int index = -1;
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] != null && id.equals(teachers[i].getId())) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public int invokeIsExisted(String id) {
        return isExisted(id);
    }

    private boolean isEmpty() {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] != null) {
                return false;
            }
        }
        return true;
    }

    public boolean invokeIsEmpty() {
        return isEmpty();
    }

    private boolean isFull() {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                return false;
            }
        }
        return true;
    }

    public boolean invokeIsFull() {
        return isFull();
    }

    private boolean deleteTeacher(String id) {
        for (int i = 0; i < teachers.length; i++) {
            if (id.equals(teachers[i].getId())) {
                teachers[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean invokeDeleteTeacher(String id) {
        return deleteTeacher(id);
    }

    private boolean editTeacher(String id, String choice, String info) {
        int index = isExisted(id);
        if (choice.equals("1")) {
            teachers[index].setName(info);
            return true;
        }
        if (choice.equals("2")) {
            teachers[index].setAge(info);
            return true;
        }
        if (choice.equals("3")) {
            teachers[index].setBirthday(info);
            return true;
        }
        return false;
    }

    public boolean invokeEditTeacher(String id, String choice, String info) {
        return editTeacher(id, choice, info);
    }
}
