package Day17.CodeReview;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestAnnotation {
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

class TestDemo {
    public static void main(String[] args) {
        Class<TestAnnotation> testAnnotationClass = TestAnnotation.class;
        TestAnnotation testAnnotation = null;
        try {
            testAnnotation = testAnnotationClass.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Method declaredMethod : testAnnotationClass.getDeclaredMethods()) {
            declaredMethod.setAccessible(true);
            if (declaredMethod.isAnnotationPresent(Test.class)) {
                try {
                    declaredMethod.invoke(testAnnotation);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
