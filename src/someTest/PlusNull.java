package someTest;

/**
 * Created by shuailu on 4/29/15.
 */
public class PlusNull {
    public static void main (String[] args) {
        Long l1 = null;
        Long l2 = null;

        long long1 = l1.longValue();

        Long l3 = l1 + l2;
    }

}
