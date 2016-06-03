package someTest;

import java.util.HashMap;

/**
 * Created by shuailu on 4/26/16.
 */
public class DropSquares {

    HashMap<Integer, Integer> map;

    DropSquares() {
        map = new HashMap<Integer, Integer>();
    }

    public void drop(int x, int e) {
        int maxHeight = 0;
        for (int n = x; n < x + e; n++) {
            Integer height = map.get(n);
            if (height == null) {
                height = 0;
            }
            maxHeight = height > maxHeight ? height : maxHeight;
        }
        for (int n = x; n < x + e; n++) {
            map.put(n, maxHeight + e);
        }
    }

    public int getHeight(double index) {
        int x = (int) index;
        Integer res = map.get(x);
        return res == null ? 0 : res;
    }




    public static void main(String[] args) {
        DropSquares dropSquares = new DropSquares();
        dropSquares.drop(1, 1);
        dropSquares.drop(1, 1);
        dropSquares.drop(0, 3);
        dropSquares.drop(0, 1);
        for (int n = 0; n <= 5; n++) {
            System.out.println(n + ": " + dropSquares.getHeight(n));
        }
        System.out.println("2.5: " + dropSquares.getHeight(2.5));

    }
}
