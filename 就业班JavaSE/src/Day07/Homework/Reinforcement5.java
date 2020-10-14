package Day07.Homework;

import java.util.ArrayList;
import java.util.Collection;

public class Reinforcement5 implements IDataOperation<Student> {
    ArrayList<Student> arrayList = new ArrayList<>();

    @Override
    public boolean add(Student t) {
//        if (isExisted(t)) {
//            System.out.println("学生已存在");
//            return false;
//        } else {
//            System.out.println("添加成功");
//            return true;
//        }
        Student student = get(t.getId());
        if (student == null) {
            arrayList.add(t);
            System.out.println("添加成功");
            return true;
        } else {
            System.out.println("学生已存在");
            return false;
        }
    }

    @Override
    public <T> boolean delete(T t) {
        Student student = get(t);
        if (student == null) {
            System.out.println("查无此人");
            return false;
        } else {
            System.out.println("删除成功");
            return arrayList.remove(student);
        }
    }

    @Override
    public <T> boolean update(Student student) {
        Student newStudent = get(student.getId());
        if (newStudent == null) {
            System.out.println("查无此人");
            return false;
        } else {
            student.setName(newStudent.getName());
            student.setAge(newStudent.getAge());
            student.setAddress(newStudent.getAddress());
            return true;
        }
    }

    @Override
    public <T> Student get(T t) {
        if (arrayList.isEmpty()) {
            System.out.println("尚未添加学生");
        } else {
            for (Student student : arrayList) {
                if (t.equals(student.getId())) {
                    return student;
                }
            }
        }
        return null;
    }

    @Override
    public Collection<Student> getAll() {
        return arrayList;
    }

//    public boolean isExisted(Student s) {
//        for (Student student : arrayList) {
//            if (s.getId().equals(student.getId())) {
//                return true;
//            }
//        }
//        return false;
//    }
}

class Test1 {
    public static void main(String[] args) {
        Reinforcement5 reinforcement5 = new Reinforcement5();

        Student student1 = new Student("1", "1", "1", "1");
        Student student2 = new Student("2", "2", "2", "2");
        Student student3 = new Student("3", "3", "3", "3");
        Student student4 = new Student("4", "4", "4", "4");

        reinforcement5.add(student1);
        reinforcement5.add(student1);
        reinforcement5.delete("1");
    }
}

//数据操作接口
interface IDataOperation<E> {
    // 添加数据
    public boolean add(E t);
    // 根据唯一标识删除一个数据
    public <T> boolean delete(T t);
    // 修改一个数据
    public <T> boolean update(E e);
    // 根据唯一表示查找一个数据
    public <T> E get(T t);
    // 查找所有数据
    public Collection<E> getAll();
}

// 标准学生类
class Student {
    private String id;// 学号
    private String name;// 姓名
    private String age;// 年龄
    private String address;// 居住地
    public Student() {}
    public Student(String id, String name, String age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
    }
}
