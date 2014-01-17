package someTest;

public class StringPermutation
{
	public static void permutation(String str)
	{
		permutation("",str);
	}
	
	private static void permutation(String prefix, String str)
	{
		if(str.length() == 0)
			System.out.println(prefix);
		else
		{
			for(int n = 0; n < str.length(); n++)
				permutation(prefix+str.charAt(n), str.subSequence(0,n) + str.substring(n+1, str.length()));
		}
	}
	
	public static void main(String[] args)
	{
		permutation("a");
	}

}
