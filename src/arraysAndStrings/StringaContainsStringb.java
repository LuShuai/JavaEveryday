package arraysAndStrings;

public class StringaContainsStringb
{

	public static boolean contains(String a, String b)
	{
		if(b == null)
			return true;
		if(a == null)
			return false;
		if(a.length() < b.length())
			return false;
		if(a.length() == b.length())
			return a.equals(b);
		
		int po = 0;
		
		for(int n = 0; n < a.length(); n++)
		{
			if(a.charAt(n) == b.charAt(po))
			{
				po++;
			}
			else
			{
				po = 0;
			}
			if(po == b.length())
				return true;
		}
		return false;
	}
	public static void main(String[] args)
	{
		System.out.println(contains("hello world",null));
	}

}
