package Day17.Code;

import java.lang.reflect.Method;

public class AnnotationTest {
    private void show() {
        System.out.println("show");
    }

    @Test
    private void method() {
        System.out.println("method");
    }

    private void function() {
        System.out.println("function");
    }
}

class Demo {
    public static void main(String[] args) {
        Class<AnnotationTest> clazz = AnnotationTest.class;
        try {
            AnnotationTest annotationTest = clazz.getConstructor().newInstance();
            for (Method declaredMethod : clazz.getDeclaredMethods()) {
                declaredMethod.setAccessible(true);
                if (declaredMethod.isAnnotationPresent(Test.class)) {
                    declaredMethod.invoke(annotationTest);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
