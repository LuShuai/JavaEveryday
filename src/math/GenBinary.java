package math;

public class GenBinary{

	/*
	 * Generate the string of binary code for a positive integer number
	 */
	public static String getBinary(int i) {
		if (i == 0) {
			return "0";
		}
		StringBuilder res = new StringBuilder();
		while (i > 0) {
			res.insert(0,i%2);
			i = i >> 1;
		}
		return new String(res);
	}
	
	/*
	 * Get the number of 1s inside the binary code of a positive integer
	 */
	public static int get1num(int i) {
		int count = 0;
		while (i > 0) {
			++count;
			i = (i - 1) & i;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(getBinary(0));
		System.out.println("number of 1s :" + get1num(0));
		System.out.println(getBinary(1));
		System.out.println("number of 1s :" + get1num(1));
		System.out.println(getBinary(2));
		System.out.println("number of 1s :" + get1num(2));
		System.out.println(getBinary(3));
		System.out.println("number of 1s :" + get1num(3));
		System.out.println(getBinary(4));
		System.out.println("number of 1s :" + get1num(4));
		System.out.println(getBinary(5));
		System.out.println("number of 1s :" + get1num(5));
		System.out.println(getBinary(6));
		System.out.println("number of 1s :" + get1num(6));

	}

}
