package arrays;

/*
 *  Given an integer array A that is first in increasing order and then becomes decreasing oder
 *  Find the largest value of it.   
 */

public class InflectedArray {
	private static final boolean D = false;
	
	public static int getMax(int[] A) {
		return getMax(A, 0, A.length - 1);
	}
	
	private static int getMax(int[] A, int left, int right) {
		if(D)
			System.out.println("left = " + left + "   right = " + right);
		if (A == null || A.length == 0 || left > right) {
			return Integer.MIN_VALUE;
		}
		if (left == right) {
			return A[left];
		}
		int mid = left + (right - left) / 2;
		if(D)
			System.out.println("mid = " + mid + "   left = " + left + "   right = " + right);
		if( mid == left || mid == right) {
			return A[right] > A[left] ? A[right] : A[left];
		} else if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
			return A[mid];
		} else if (A[mid] < A[mid + 1]) {
			return getMax(A, mid + 1, right);
		} else if (A[mid] < A[mid - 1]) {
			return getMax(A, left, mid - 1);
		} else {
			return Integer.MIN_VALUE;
		}
	}
	
	public static void main(String[] args) {
		int a[] = {1,2,4,5,2};
		System.out.println(getMax(a));

	}

}
