package Day05.CodeReview;

import java.util.Objects;

public class ObjectsReview {
    public static void main(String[] args) {
        Alien alien1 = new Alien("ET", "???");
        System.out.println(Objects.toString(alien1));

        Alien alien2 = null;
        Alien alien3 = new Alien("异形", "???");
        System.out.println(Objects.toString(alien3, "普罗米修斯"));
        System.out.println(Objects.toString(alien2, "工程师"));
        System.out.println(Objects.isNull(alien2));
        System.out.println(Objects.isNull(alien3));
        System.out.println(Objects.nonNull(alien2));
        System.out.println(Objects.nonNull(alien3));
    }
}

class Alien {
    private String name;
    private String age;

    public Alien() {
    }

    public Alien(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
