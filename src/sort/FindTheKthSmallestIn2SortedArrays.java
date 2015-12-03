package sort;

public class FindTheKthSmallestIn2SortedArrays {

    private static int findKth2(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {
        //base case:
        if (aStart > aEnd) {
            return B[bStart + k - 1];
        }
        if (bStart > bEnd) {
            return A[aStart + k - 1];
        }
        if (k == 1) {
            return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
        }

        //recursion case:
        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        int aMid = aStart + (int) ((k - 1) * (double) aLen / (aLen + bLen));
        int bMid = bStart + k - 2 - (aMid - aStart);

        if (A[aMid] < B[bMid]) {
            k = k - (aEnd - aStart + 1);
            aStart = aMid + 1;
            bEnd = bMid;
        } else {
            k = k - (bEnd - bStart + 1);
            bStart = bMid + 1;
            aEnd = aMid;
        }
        return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
    }


    public static int findKth(int[] a, int[] b, int k, int aStart, int aEnd, int bStart, int bEnd) {
        System.out.println("aStart : " + aStart + "\taEnd : " + aEnd);
        System.out.println("bStart : " + bStart + "\tbEnd : " + bEnd);
        //base case
        if (aStart > aEnd) {
            return b[bStart + k - 1];
        }
        if (bStart > bEnd) {
            return a[aStart + k - 1];
        }
        if (k == 1) {
            return a[aStart] < b[bStart] ? a[aStart] : b[bStart];
        }
        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        //recursion case
        int aMid = aStart + (int) ((k - 1) * ((float) aLen / (aLen + bLen)));
        int bMid = bStart + (k - (aMid - aStart) - 2);

        System.out.println("aMid = " + aMid);
        System.out.println("bMid = " + bMid);

        if (a[aMid] < b[bMid]) {
            k = k - (aMid - aStart) - 1;
            aStart = aMid + 1;
            bEnd = bMid;
        } else {
            k = k - (bMid - bStart) - 1;
            bStart = bMid + 1;
            aEnd = aMid;
        }
        return findKth(a, b, k, aStart, aEnd, bStart, bEnd);
    }

    public static int findKth(int[] a, int[] b, int k) {
        return findKth(a, b, k, 0, a.length - 1, 0, b.length - 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 1};
        int[] b = {1, 1};
        System.out.println(findKth(a, b, 2));

    }

}
