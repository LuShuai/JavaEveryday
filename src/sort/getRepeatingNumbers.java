package sort;

import java.util.HashSet;

public class getRepeatingNumbers {

    public static HashSet<Integer> getRepeat(int[] a) {
        HashSet<Integer> res = new HashSet<Integer>();
        int current = 0;
        while (current < a.length) {
            //put the number in the start position into 'hand'
            int start = current;
            int inHand = a[start];
            while (start != inHand) {
                //get a repeating value
                if (a[inHand] == inHand) {
                    res.add(inHand);
                    break;
                } else {
                    //put the number in hand into the proper position and get a new number in
                    //that position into hand
                    int temp = a[inHand];
                    a[inHand] = inHand;
                    inHand = temp;
                }
            }
            //put the number in hand into start position
            a[start] = inHand;
            ++current;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 3, 5, 2, 3, 0, 0};
        System.out.println(getRepeat(a));
    }
}
