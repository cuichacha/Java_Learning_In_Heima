package Day17.Code;

public enum Season {
    SPRING("春") {
        @Override
        public void show() {
            System.out.println(this.getName());
        }
    },

    SUMMER("夏") {
        @Override
        public void show() {
            System.out.println(this.getName());
        }
    },

    AUTUMN("秋") {
        @Override
        public void show() {
            System.out.println(this.getName());
        }
    },

    WINTER("冬") {
        @Override
        public void show() {
            System.out.println(this.getName());
        }
    };

    private String name;

    public String getName() {
        return name;
    }

    /*
    Season() {
    }
     */

    Season(String name) {
        this.name = name;
    }

    public abstract void show();
}
