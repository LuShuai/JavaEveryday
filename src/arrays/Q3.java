package arrays;

public class Q3
{

	/**
	 *Given two strings, write a method to decide if one is a permutation of the other.
	 *
	 *Shuai Lu
	 *Sep. 22
	 */
	
	public static boolean isPermutation(String s1, String s2)
	{
		int[] alphabet = new int[256];
		for (int n = 0; n<256; n++)
			alphabet[n] = 0;
		char[] ca1 = s1.toCharArray();
		for(int n = 0; n<ca1.length; n++)
			++alphabet[(int)ca1[n]];
		for(int n =0; n< s2.length(); n++)
		{
			--alphabet[(int)s2.charAt(n)];
			if(alphabet[(int)s2.charAt(n)] < 0)
				return false;
		}
		
		for(int n = 0; n< 256; n++)
			if(alphabet[n] != 0)
				return false;
		return true;
		
	}
	
	public static void main(String[] args)
	{
		String s1 = "hello, world";
		String s2 = "world, hello";
		String s3 = "word, hallo";
		
		System.out.println(""+isPermutation(s1,s2));
		System.out.println(""+isPermutation(s1,s3));
		System.out.println(""+isPermutation(s2,s3));

	}

}
