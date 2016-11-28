package math;

public class Divide {

    /*
     * Divided two integers without '/' and '*'
     */
    public static int divide(int devidend, int devisor) {
        if (devisor == 0) {
            return Integer.MIN_VALUE;
        }
        if (devidend == 0 || devisor == 1) {
            return devidend;
        }
        long dvd = (devidend > 0 ? (long) devidend : -(long) devidend);
        long dvs = (long) (devisor > 0 ? (long) devisor : -(long) devisor);
        System.out.println("a=" + dvd);
        System.out.println("b=" + dvs);
        int res = 0;
        while (dvd >= dvs) {
            long current = dvs;
            for (int i = 0; dvd >= current; i++) {
                dvd -= current;
                res += 1 << i;
                current = current << 1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(divide(7, 2));

    }

}
