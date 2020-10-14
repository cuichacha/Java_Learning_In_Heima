package Day17.CodeReview;

public @interface AnnotationDemo1 {
    public float f() default 0.0F;
    public String str() default "";
    public Class clazz() default AnnotationDemo1.class;
    public AnnotationDemo2 annotation() default @AnnotationDemo2;
    public Season season() default Season.SPRING;
    public float[] fi() default {0.1F, 02.F};
    public Season[] seasons() default {Season.SPRING, Season.SUMMER, Season.AUTUMN, Season.WINTER};

}
