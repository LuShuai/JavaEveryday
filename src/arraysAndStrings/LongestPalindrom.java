package arraysAndStrings;

public class LongestPalindrom
{
	//find the longest palindrome sub-string
	public static String longestPalindrome(String s)
	{
		if(s == null || s == "" ||s.length() == 0)
		{
			return null;
		}
		boolean[][] a = new boolean[s.length()][s.length()];
		return longestPalindrome(s,a);
		
	}
	
	private static String longestPalindrome(String s, boolean a[][])
	{
		int size = a.length; // row = column
		
		//for sub-string with length == 1
		for(int n = 0; n < size; n++)
		{
			a[n][n] = true;
		}
		int longestBegin = size-1;
		int maxLength = 1;
		//for sub-string with length == 2
		for(int n = 0; n < size-1; n++)
		{
			if(s.charAt(n+1) == s.charAt(n))
			{
				a[n][n+1] = true;
				longestBegin = n;
				maxLength = 2;
			}
		}
		//for sub-string with length >= 3
		for(int length = 3; length <= size; length++)
		{
			for(int i = 0; i < size -length +1; i++)
			{
				if(s.charAt(i) == s.charAt(i+length-1) && a[i+1][i+length-2])
				{
					a[i][i+length-1] = true;
					longestBegin = i;
					maxLength = length;
				}
			}
		}
		return s.substring(longestBegin, longestBegin+maxLength);
		
	}

	
	
	public static void main(String[] args)
	{
		System.out.println(longestPalindrome(""));
	}

}
