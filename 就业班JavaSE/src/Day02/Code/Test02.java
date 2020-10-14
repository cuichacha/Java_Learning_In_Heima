package Day02.Code;

public class Test02 {
    public static void main(String[] args) {
        new Test04().method();
    }
}

class Test04 {
    public Test04() {
    }

    public void method() {
        System.out.println(12345);
    }

    {
        System.out.println("啦啦阿拉");
    }

    static {
        System.out.println("叽里呱啦");
    }
}
