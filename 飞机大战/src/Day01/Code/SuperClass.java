package Day01.Code;

public class SuperClass {
    String name;

    public SuperClass() {
        System.out.println("父类");
    }

    public SuperClass(String name) {
        this.name = name;
        System.out.println(""+ name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("爸爸");
    }
}
