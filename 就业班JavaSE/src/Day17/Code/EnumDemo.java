package Day17.Code;

public class EnumDemo {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SPRING.getName());
        System.out.println(Season.SUMMER);
        System.out.println(Season.SUMMER.getName());
        System.out.println(Season.AUTUMN);
        System.out.println(Season.AUTUMN.getName());
        System.out.println(Season.WINTER);
        System.out.println(Season.WINTER.getName());
        System.out.println("-------------------------------");

        System.out.println(Season.SPRING.name());
        System.out.println("-------------------------------");

        System.out.println(Season.SUMMER.ordinal());
        System.out.println("-------------------------------");

        System.out.println(Season.WINTER.compareTo(Season.SUMMER));
        System.out.println("-------------------------------");

        System.out.println(Season.AUTUMN.toString());
        System.out.println("-------------------------------");

        System.out.println(Enum.valueOf(Season.class, "AUTUMN"));
        System.out.println("-------------------------------");

        System.out.println(Season.valueOf("WINTER"));
        System.out.println("-------------------------------");

        System.out.println(Season.valueOf(Season.class, "SUMMER"));
        System.out.println("-------------------------------");

        for (Season value : Season.values()) {
            System.out.println(value);
        }
    }
}
