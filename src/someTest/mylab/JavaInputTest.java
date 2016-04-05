package someTest.mylab;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by shuailu on 2/17/16.
 */
public class JavaInputTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(data));
    }

}
