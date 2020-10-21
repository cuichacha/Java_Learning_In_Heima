package Day07.Homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Collection1 {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();

        collection.add("JavaEE企业级开发指南");
        collection.add("Oracle高级编程");
        collection.add("MySQL从入门到精通");
        collection.add("Java架构师之路");

        Iterator<String> iterator = collection.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("---------------------");

        iterator = collection.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.length() < 10) {
                System.out.println(str);
            }
        }
        /*
            出bug的地方，在于源码中，next方法中，cursor进行了+1操作，所以25行会让cursor+1，26行在执行的时候也会让cursor+1
            因此这段代码里，cursor的值不是+1递增，
            第一次循环，cursor的值为0，while判断为true，进入if判断+1，if判断为false，回到while
            第二次循环，cursor的值为1，while判断为true，进入if判断+1，if判断为false，回到while
            注意！！
            第三次循环，cursor的值为2，while判断为true，进入if判断+1，
                if判断为true！cursor+1，cursor此时为3，在集合的最后一个位置，
                   然后执行26行，next方法又要+1，cursor指向4，没有这个元素，所以无法打印+报错

         */

//        iterator1 = collection.iterator();
//        while(iterator1.hasNext()) {
//            String book = iterator1.next();
//            if(book.length()<10) {//判断书名小于10个字符
//                System.out.println(book);
//            }
//        }

        System.out.println("---------------------");

        iterator = collection.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.contains("Java")) {
                System.out.println(str);
            }
        }

        System.out.println("---------------------");

        iterator = collection.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.contains("Oracle")) {
                iterator.remove();
            }
        }

        System.out.println("---------------------");

        for (String s : collection) {
            System.out.println(s);
        }

        System.out.println("---------------------");


    }
}
