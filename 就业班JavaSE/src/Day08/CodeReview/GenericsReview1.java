package Day08.CodeReview;

public class GenericsReview1 {
    public static void main(String[] args) {
        Box<String> box1 = new Box<>();
        box1.setE("111");
        System.out.println(box1.getE());

        Box<Integer> box2 = new Box<>();
        box2.setE(1);
        System.out.println(box2.getE());
    }
}

class Box<E> {
    private E e;

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}