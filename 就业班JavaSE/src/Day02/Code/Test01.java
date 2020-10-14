package Day02.Code;

public class Test01 {
    public static void main(String[] args) {
        new Test03().method();
    }
}

class Test03 {
    public Test03() {
    }

    public void method() {
        System.out.println(12345);
    }

    {
        System.out.println("啦啦阿拉");
    }
}
