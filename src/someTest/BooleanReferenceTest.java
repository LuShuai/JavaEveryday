package someTest;

/**
 * Created by shuailu on 5/5/16.
 */
public class BooleanReferenceTest {

    public static void main(String[] args) {
        Boolean b1 = new Boolean(true);
        Boolean b2 = Boolean.TRUE;
        Boolean b3 = Boolean.TRUE;

        System.out.println(b1 == true);
        System.out.println(b1.equals(true));

        System.out.println(b2 == true);
        System.out.println(b2.equals(true));

        System.out.println(b2 == b1);
        System.out.println(b2.equals(b1));

        System.out.println(b2 == b3);
        System.out.println(b2.equals(b3));


        System.out.println("hashCode of b1:" + b1.hashCode());
        System.out.println("hashCode of b2:" + b2.hashCode());
        System.out.println("hashCode of b3:" + b3.hashCode());

    }

}
