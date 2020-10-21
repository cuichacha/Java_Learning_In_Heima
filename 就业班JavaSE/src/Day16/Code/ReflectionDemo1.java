package Day16.Code;

public class ReflectionDemo1 {
    public static void main(String[] args) {
        System.out.println(Demo1.class);
        try {
            System.out.println(Class.forName("Day16.Code.Demo1"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(new Demo1().getClass());
    }
}

class Demo1 {

}
