package string;

/* 
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
a) Insert a character
b) Delete a character
c) Replace a character
 */

public class EditDistance{
	
	public static int getDistance(String word1, String word2) {
		if (word1 == null || word1.length() == 0) {
			return word2 == null ? 0 : word2.length();
		}
		if (word2 == null || word2.length() == 0) {
			return word1 == null ? 0 : word1.length();
		}
		int[][] dist = new int[word1.length() + 1][word2.length() + 1];
		//init dp array.
		for (int n = 0; n < dist.length; n++) {
			dist[n][0] = n;
		}
		for (int n = 0; n < dist[0].length; n++) {
			dist[0][n] = n;
		}
		
		for (int m = 0; m < word1.length(); m++) {
			for (int n = 0; n < word2.length(); n++) {
				if (word1.charAt(m) == word2.charAt(n)) {
					dist[m + 1][n + 1] = dist[m][n];
				} else {
					int delete = dist[m][n + 1];
					int insert = dist[m + 1][n];
					int replace = dist[m][n];
					dist[m + 1][n + 1] = 1 + Math.min(delete, Math.min(insert, replace));
				}
			}
		}
		return dist[word1.length()][word2.length()];
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		String s1 = "a";
		String s2 = "b";
		String s3 = "aa";
		String s4 = "hello, world";
		String s5 = "hello";
		
		System.out.println(getDistance(s1,s1));
		System.out.println(getDistance(s1,s2));
		System.out.println(getDistance(s1,s3));
		System.out.println(getDistance(s2,s3));
		System.out.println(getDistance(s3,s4));
		System.out.println(getDistance(s4,s5));
		
	}

}
