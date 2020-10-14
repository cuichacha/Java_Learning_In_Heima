package Day01.Code;

public class Test {

    public static void main(String[] args) {
//        SubClass subClass1 = new SubClass();
//        SubClass subClass2 = new SubClass("哈哈");
//        SuperClass superClass = new SuperClass();
//        subClass1.show();

//        Teacher teacher1 = new Teacher();
//        teacher1.setName("哈哈");
//        teacher1.setAge(0);
//        System.out.println(teacher1.getName() + "..." + teacher1.getAge());
//        teacher1.teach();
//
//        Teacher teacher2 = new Teacher("啦啦", 0);
//        System.out.println(teacher2.getName() + "..." + teacher2.getAge());
//        teacher2.teach();
//
//        Student student1 = new Student();
//        student1.setName("啊啊");
//        student1.setAge(0);
//        System.out.println(student1.getName() + "..." + student1.getAge());
//        student1.study();
//
//        Student student2= new Student("哦哦", 0);
//        System.out.println(student2.getName() + "..." + student2.getAge());
//        student2.study();

        Cat cat1 = new Cat();
        cat1.setName("加菲");
        cat1.setAge(1);
        System.out.println(cat1.getName() + "..." + cat1.getAge());
        cat1.catchMice();

        Cat cat2 = new Cat("汤姆", 1);
        System.out.println(cat2.getName() + "..." + cat2.getAge());
        cat2.catchMice();

        Dog dog1 = new Dog();
        dog1.setName("啊啊");
        dog1.setAge(1);
        System.out.println(dog1.getName() + "..." + dog1.getAge());
        dog1.watchDoor();

        Dog dog2= new Dog("哦哦", 1);
        System.out.println(dog2.getName() + "..." + dog2.getAge());
        dog2.watchDoor();
    }
}
