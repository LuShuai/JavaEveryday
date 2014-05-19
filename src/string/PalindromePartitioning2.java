package string;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/




public class PalindromePartitioning2{
	
	public static int minCut(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		boolean[][] isPa = new boolean[s.length()][s.length()];
		int[] cutNum = new int[s.length()];
		
		for (int n = 0; n < s.length(); n++) {
			cutNum[n] = s.length() - n;		
		}
		
		for (int m = 0; m < isPa.length; m++) {
			for (int n = 0; n < isPa.length; n++) {
				isPa[m][n] = false;
			}
		}
		
		for (int start = s.length() - 1; start >= 0; start--) {
			for (int end = start; end < s.length(); end ++) {
				int len = end - start + 1;
				if (s.charAt(start) == s.charAt(end) && (len <=3 || isPa[start + 1][end - 1])) {
					isPa[start][end] = true;
					cutNum[start] = Math.min(cutNum[start], cutNum[end + 1] + 1);
				}
			}
		}
		return cutNum[0] - 1;
	}
	
	public static void main(String[] args){
		System.out.println(minCut("abc"));
	}

}
