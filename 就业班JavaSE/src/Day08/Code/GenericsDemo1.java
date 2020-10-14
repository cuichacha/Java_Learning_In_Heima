package Day08.Code;

public class GenericsDemo1 {
    public static void main(String[] args) {
        Box<String> box1 = new Box<>();
        box1.setElement("啦啦啦");
        System.out.println(box1.getElement());

        Box<Integer> box2 = new Box<>();
        box2.setElement(123);
        System.out.println(box2.getElement());
    }
}

class Box<E> {
    private E element;

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }
}
