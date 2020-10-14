package Day17.CodeReview;

public enum Season {
    SPRING("春") {
        @Override
        public void show() {
            System.out.println("春");
        }
    },
    SUMMER("夏") {
        @Override
        public void show() {
            System.out.println("夏");
        }
    }, AUTUMN("秋") {
        @Override
        public void show() {
            System.out.println("秋");
        }
    }, WINTER("冬") {
        @Override
        public void show() {
            System.out.println("冬");
        }
    };

    private String name;

//    Season() {
//    }

    Season(String name) {
        this.name = name;
    }

    public abstract void show();
}

class EnumDemo {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
        System.out.println("---------------------------");
        Season.SPRING.show();
        Season.SUMMER.show();
        Season.AUTUMN.show();
        Season.WINTER.show();
        System.out.println("---------------------------");
        System.out.println(Season.SPRING.ordinal());
        System.out.println(Season.SUMMER.ordinal());
        System.out.println(Season.AUTUMN.ordinal());
        System.out.println(Season.WINTER.ordinal());
        System.out.println("---------------------------");
        for (Season value : Season.values()) {
            System.out.println(value);
        }
        System.out.println("---------------------------");
        System.out.println(Season.valueOf("SPRING"));
        System.out.println(Season.valueOf("SUMMER"));
        System.out.println(Season.valueOf("AUTUMN"));
        System.out.println(Season.valueOf("WINTER"));
        System.out.println("---------------------------");
        System.out.println(Season.valueOf(Season.class, "SPRING"));
        System.out.println(Season.valueOf(Season.class, "SUMMER"));
        System.out.println(Season.valueOf(Season.class, "AUTUMN"));
        System.out.println(Season.valueOf(Season.class, "WINTER"));
        System.out.println("---------------------------");
        System.out.println(Season.SPRING.name());
        System.out.println(Season.SUMMER.name());
        System.out.println(Season.AUTUMN.name());
        System.out.println(Season.WINTER.name());
        System.out.println("---------------------------");
        System.out.println(Season.SPRING.compareTo(Season.AUTUMN));
    }
}
