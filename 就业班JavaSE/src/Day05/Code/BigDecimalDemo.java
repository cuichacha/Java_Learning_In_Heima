package Day05.Code;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("1.56");
        BigDecimal bigDecimal2 = new BigDecimal("2.78");
//        BigDecimal bigDecimal3 = new BigDecimal("abs");
//        System.out.println(bigDecimal3);

        System.out.println(bigDecimal1.add(bigDecimal2));
        System.out.println(bigDecimal1.subtract(bigDecimal2));
        System.out.println(bigDecimal1.multiply(bigDecimal2));
//        System.out.println(bigDecimal1.divide(bigDecimal2));
        System.out.println(bigDecimal1.divide(bigDecimal2, 12, RoundingMode.FLOOR));
    }
}
