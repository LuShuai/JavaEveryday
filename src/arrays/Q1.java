package arrays;

public class Q1
{

	/**
	 * Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
	 * Shuai Lu  
	 * Sep. 22
	 */
	
	
	public static boolean hasUnique(String s)
	{
		if(s.length() < 1)
			return true;
		if(s.length() > 256)
			return false;
		boolean[] alphabet = new boolean[256];
		for(int n=0; n<256; n++)
			alphabet[n] = false;
		char[] ca = s.toCharArray();
		for(char c: ca)
		{
			int charCode = (int) c;
			if(alphabet[charCode] == false)
				alphabet[charCode] = true;
			else
				return false;
		}
		return true;
		
	}
	
	
	public static void main(String[] args)
	{
		System.out.println(""+hasUnique("abcd"));

	}

}
