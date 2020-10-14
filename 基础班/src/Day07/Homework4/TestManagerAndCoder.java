package Day07.Homework4;

public class TestManagerAndCoder {
    public static void main(String[] args) {
        Manager manager = new Manager("项目经理", 123, 15000, 6000);
        Coder coder = new Coder("程序员", 135, 10000);

        manager.work();
        coder.work();
    }
}
