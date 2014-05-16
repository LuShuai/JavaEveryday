package math;

public class PalindromNumber{
	public static boolean isPalindrome(int num) {
		int div = (int)Math.pow(10,(int)Math.log10(num));
		while (num != 0) {
			int left = num / div;
			int right = num % 10;
			if (left != right) {
				return false;
			}
			num = (num % div) / 10;
			div /= 100;
		}
		return true;
	}
	
	public static void main(String[] args){
		System.out.println(isPalindrome(0));	//true
		System.out.println(isPalindrome(1));	//true
		System.out.println(isPalindrome(11));	//true 
		System.out.println(isPalindrome(121));	//true
		System.out.println(isPalindrome(123));	//false
		System.out.println(isPalindrome(12));	//false
		System.out.println(isPalindrome(567898765));	//true
		System.out.println(isPalindrome(12345321));		//false		
	}

}
