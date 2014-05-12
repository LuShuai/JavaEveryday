package arrays;

public class Q5
{

	/**
	 * Write a method to replace all space in a string to '%20'
	 */
	
	
	public static String replace(String str)
	{
		int num = 0;    //number of space in str
		for(int n = 0; n<str.length(); n++)
			if(str.charAt(n) == ' ')
				++num;
		char[] ca = new char[str.length()+num*2];
		int ca_pointer = 0;
		for(int n  = 0; n < str.length(); n++)
		{
			if(str.charAt(n) != ' ')
				ca[ca_pointer++] = str.charAt(n);
			else
			{
				ca[ca_pointer++] = '%';
				ca[ca_pointer++] = '2';
				ca[ca_pointer++] = '0';
			}
		}
		return new String(ca);
	}
	
	
	
	public static void main(String[] args)
	{
		System.out.println(replace("H ello, wor ld ! "));

	}

}
