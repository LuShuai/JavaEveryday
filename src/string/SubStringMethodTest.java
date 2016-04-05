package string;

/**
 * Created by shuailu on 1/14/16.
 */
public class SubStringMethodTest {

    public static void main(String[] args) {
        String[] strs = "".split(",");
        for (String s : strs) {
            System.out.println(s);
        }

        System.out.println("length: " + strs.length);
    }

}
