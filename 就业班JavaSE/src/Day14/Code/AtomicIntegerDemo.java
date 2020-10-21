package Day14.Code;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger1 = new AtomicInteger();
        AtomicInteger atomicInteger2 = new AtomicInteger(10);
        System.out.println(atomicInteger1);
        System.out.println(atomicInteger2);

        System.out.println(atomicInteger1.incrementAndGet());
        System.out.println(atomicInteger1.getAndIncrement());
        System.out.println(atomicInteger1.get());

        System.out.println("-------------------------------");

        System.out.println(atomicInteger1.decrementAndGet());
        System.out.println(atomicInteger1.getAndDecrement());
        System.out.println(atomicInteger1.get());

        System.out.println("-------------------------------");

        System.out.println(atomicInteger1.addAndGet(5));
        System.out.println(atomicInteger1.getAndAdd(5));
        System.out.println(atomicInteger1.get());

        System.out.println("-------------------------------");

        System.out.println(atomicInteger1.getAndSet(50));
        System.out.println(atomicInteger1.get());
    }
}
