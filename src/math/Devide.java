package math;

public class Devide {

    /*
	 * Devided two integers without '/' and '*'
     */
    public static int divide(int devidend, int devisor) {
        if (devisor == 0) {
            return Integer.MIN_VALUE;
        }
        if (devidend == 0 || devisor == 1) {
            return devidend;
        }
        long a = (devidend > 0 ? (long) devidend : -(long) devidend);
        long b = (long) (devisor > 0 ? (long) devisor : -(long) devisor);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        int res = 0;
        while (a >= b) {
            long c = b;
            for (int i = 0; a >= c; i++) {
                a -= c;
                res += 1 << i;
                c = c << 1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 2));

    }

}
