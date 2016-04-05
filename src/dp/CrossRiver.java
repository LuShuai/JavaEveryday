package dp;

/**
 * Created by shuailu on 1/29/16.
 */
public class CrossRiver {





    private static boolean canPass(boolean[] river, int speed, int position) {
        if (position + speed + 1 >= river.length) {
            return true;
        }

        //speed up
        if (river[position + speed + 1]) {
            return canPass(river, speed + 1, position + speed + 1);
        }

        //same speed
        if (speed > 0 && river[position + speed]) {
            return canPass(river, speed, position + speed);
        }

        //slow down
        if (speed - 1 > 0 && river[position + speed - 1]) {
            return canPass(river, speed - 1, position + speed - 1);
        }

        return false;
    }

    public static boolean canPass(boolean[] river) {
        if (river != null && river.length > 0) {
            return river[0] && canPass(river, 1, 0);
        }
        return true;
    }

    public static void main(String[] args) {
        boolean[] river1 = {true, false, true, false, true}; //can pass
        boolean[] river2 = {true, false, false, false, true}; //cannot pass
        boolean[] river3 = {true, true, false, false, false, true}; //cannot pass

        System.out.println(canPass(river1));
        System.out.println(canPass(river2));
        System.out.println(canPass(river3));
    }


}
