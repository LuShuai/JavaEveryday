package someTest;

/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.
 */

public class CountAndSay{
	private static final boolean D = false;
	public static String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        if (n == 1) {
            return "1";
        }
        String former = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        int p = 0;
        while (p < former.length()) {
            int count = 1;
            char say = former.charAt(p);
            while (p+1 < former.length() && former.charAt(p + 1) == say) {
                count ++;
                p++;
            }
            if (D) {
            	System.out.println("count: " + count);
            	System.out.println("say: " + say);
            }
            res.append(count);
            res.append(say);
            p++;
        }
        return new String(res);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println(countAndSay(15));

	}

}
