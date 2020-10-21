package Day17.Code;

public @interface AnnotationDemo1 {
    public int num() default 0;

    public String name();

    public Class<?> clazz() default AnnotationDemo2.class;

    public AnnotationDemo2 annotation2() default @AnnotationDemo2;

    public Season season() default Season.SPRING;

    public int[] numbers() default {1, 2, 3, 4, 5};

    public Season[] seasons() default {Season.SPRING, Season.SUMMER, Season.AUTUMN, Season.WINTER};
}
