package Day14.CodeReview;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicReview {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.get());                      // 0
        System.out.println(atomicInteger.getAndSet(5));      // 0
        System.out.println(atomicInteger.getAndAdd(5));         // 5
        System.out.println(atomicInteger.addAndGet(5));         // 15
        System.out.println(atomicInteger.getAndIncrement());          // 15
        System.out.println(atomicInteger.incrementAndGet());          // 17
        System.out.println(atomicInteger.getAndDecrement());          // 17
        System.out.println(atomicInteger.decrementAndGet());          // 15
    }
}
