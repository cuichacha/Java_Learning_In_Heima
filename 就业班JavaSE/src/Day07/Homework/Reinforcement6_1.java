package Day07.Homework;

import java.util.Arrays;
import java.util.LinkedList;

public class Reinforcement6_1<E> {
    LinkedList<E> linkedList = new LinkedList<>();


    private boolean isExisted(E e) {
        for (E element : linkedList) {
            if (e.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void add(E e) {
        if (isExisted(e)) {
            System.out.println("已存在，无法添加");
        } else {
            linkedList.add(e);
        }
    }

    public <T> LinkedList<T> addElement(LinkedList<T> linkedList, T t1, T t2, T t3) {
        linkedList.add(t1);
        linkedList.add(t2);
        linkedList.add(t3);
        return linkedList;
    }


}

class Test3 {

    public static void main(String[] args) {
        Reinforcement6_1<Human> reinforcement6_1 = new Reinforcement6_1<>();


        Human human1 = new Human("1", 1);
        Human human2 = new Human("1", 1);
        Human human3 = new Human("3", 3);


        reinforcement6_1.add(human1);
        reinforcement6_1.add(human2);
        reinforcement6_1.add(human3);

        System.out.println(Arrays.toString(reinforcement6_1.linkedList.toArray(new Human[reinforcement6_1.linkedList.size()])));
    }
}
