package Day05.CodeReview;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalReview {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = BigDecimal.valueOf(1.2);
        BigDecimal bigDecimal2 = new BigDecimal(1.2);
        BigDecimal bigDecimal3 = new BigDecimal("1.2");
        BigDecimal bigDecimal4 = new BigDecimal("0.7");

        System.out.println(bigDecimal3.divide(bigDecimal4, 6, RoundingMode.HALF_UP)); // 四舍五入
        System.out.println(bigDecimal3.divide(bigDecimal4, 6, RoundingMode.UP)); // 进一
        System.out.println(bigDecimal3.divide(bigDecimal4, 6, RoundingMode.DOWN)); // 去尾
    }
}
