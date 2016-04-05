package arrays;

import java.util.Arrays;

/**
 * Created by shuailu on 3/16/16.
 */
public class StringSplitToArrTest {

    public static void main(String[] args) {
        String s = "1;2;";

        String[] errors = s.split(";");
        System.out.println(errors.length);
        System.out.println(Arrays.toString(errors));
    }

}
