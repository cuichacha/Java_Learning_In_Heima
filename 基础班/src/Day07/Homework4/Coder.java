package Day07.Homework4;

public final class Coder {
    private String name;
    private int id;
    private double salary;

    public Coder() {
    }

    public Coder(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public final void work() {
        System.out.println("工号为" + id + "基本工资为" + salary + "的" + name + "正在努力的写着代码......");
    }
}
