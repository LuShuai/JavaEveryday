package math;

public class Add {

	public static String addOne_iterative(String num) {
		StringBuilder sb = new StringBuilder();
		int carry = 1;
		int index = num.length() - 1;
		while (index >=0 && carry > 0) {
			int unit = num.charAt(index) - '0' + carry;
			sb.insert(0, unit%10);
			carry = unit/10;
			--index;
		}
		while (index >= 0) {
			sb.insert(0, num.charAt(index));
			--index;
		}
		return new String(sb);
	}
	
	public static String addOne_recursive(String num) {
		String current = "";
		String[] sa = new String[1];
		sa[0] = current;
		addOne_helper(num, sa, 1);
		return sa[0];
	}
	
	private static void addOne_helper(String num, String[] current, int carry) {
		if (carry == 0) {
			current[0] = num + current[0];
			return;
		}
		if (num == null || num.length() == 0) {
			if (carry > 0) {
				current[0] = carry + current[0];
			}
			return;
		}
		int unit = num.charAt(num.length() - 1) - '0' + carry;
		current[0] = unit % 10 + current[0];
		addOne_helper(num.substring(0,num.length() - 1), current, unit/10);
	}
	
	//return the sum of two numbers
	public static String add(String num1, String num2) {
		if (num1 == null || num1.length() == 0) {
			return num2;
		}
		if (num2 == null || num2.length() == 0) {
			return num1;
		}
		
		StringBuilder sb = new StringBuilder();
		int offset = 0;
		int carry = 0;
		while (num1.length() - 1 - offset >= 0 && num2.length() - 1 -offset >= 0) {
			int unit = num1.charAt(num1.length() - 1 - offset) - '0' 
					+ num2.charAt(num2.length() - 1 - offset) - '0'
					+ carry;
			sb.insert(0, unit%10);
			carry = unit / 10;
			offset ++;
		}
		if (num1.length() - 1 - offset >= 0 || num2.length() - 1 -offset >= 0 ) {
			if (num1.length() - 1 - offset < 0 ) {
				if (carry == 0) {
					sb.insert(0,num2.substring(0, num2.length() - offset));
				} else {
					sb.insert(0,addOne_iterative(num2.substring(0, num2.length() - offset)));
				}
			} else {
				if(carry == 0) {
					sb.insert(0,num1.substring(0, num1.length() - offset));
				} else {
					sb.insert(0,addOne_iterative(num1.substring(0, num1.length() - offset)));
				}
			}
			return new String(sb);
		}
		return carry > 0 ? carry + new String(sb) : new String(sb); 
		
	}
	
	public static void main(String[] args){
		String s1 = "82";
		String s2 = "18";
		System.out.println(addOne_iterative(s1));
		System.out.println(addOne_recursive(s1));
		System.out.println(add(s1, s2));
	}

}
