package Day03.Homework.Practice.Host;

public class Test {

    public static void main(String[] args) {
        Student student1 = new MaleStudent();
        Student student2 = new FemaleStudent();

        Host host = new FemaleStudent();
        Class theClass = new Class();

        theClass.gala(host, student1);
        theClass.gala(host, student2);

    }
}
