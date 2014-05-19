package string;

import java.util.ArrayList;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 */

public class PalindromePartition {
	public static ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (s == null || s.length() == 0) {
			return res;
		}
		boolean[][] isPa = new boolean[s.length()][s.length()];
		for (int n = 0; n < isPa.length; n++) {
			isPa[n][n] = true;
		}
		for (int len = 2; len <= isPa.length; len++) {
			for (int start = 0; start + len - 1 < isPa.length; start ++) {
				if (s.charAt(start) == s.charAt(start + len - 1) && (len <=3 || isPa[start + 1][start + len - 2])) {
					isPa[start][start + len - 1] = true;
				} else {
					isPa[start][start + len - 1] = false;
				}
			}
		}
		return partitionHelper(s, 0, isPa);
	}
	
	private static ArrayList<ArrayList<String>> partitionHelper(String s, int p, boolean[][] isPa) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (p == s.length()) {
			res.add(new ArrayList<String>());
			return res;
		}
		for (int n = p; n < s.length(); n++) {
			if (isPa[p][n]) {
				for (ArrayList<String> l : partitionHelper(s, n + 1, isPa)) {
					l.add(0, s.substring(p, n+1));
					res.add(l);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		
	}

}
