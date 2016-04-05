package someTest;

import java.math.BigDecimal;

/**
 * Created by shuailu on 12/3/15.
 */
public class NegaTest {

    public static void main(String[] args) {
        BigDecimal dec = new BigDecimal(5);
        System.out.println(dec.negate());
        System.out.println(dec.negate().negate());
    }

}
