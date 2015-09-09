package someTest;

/**
 * Created by shuailu on 8/19/15.
 */
public class IntegerParam {

    public static void main (String[] args) {
        Integer a = 4;
        updateVal(a);
        System.out.println(a);
    }

    private static void updateVal(Integer a) {
        a++;
    }

}
