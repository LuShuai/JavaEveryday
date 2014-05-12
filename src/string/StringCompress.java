package string;


public class StringCompress
{
	private static int getNewLength(String str)
	{
		if(str == null || str.length() == 0)
		{
			return 0;
		}
		if(str.length() == 1)
		{
			return 1;
		}
		//get the new length of the compressed string
		int newLength = 0;
		int counter = 1;
		for(int n = 1; n < str.length(); n++)
		{
			if(str.charAt(n) == str.charAt(n-1))
			{
				++counter;
			}
			else
			{
				if(counter == 1)
				{
					newLength += 1;
				}
				else
				{
					newLength += 2 + (int)(Math.log((double)counter)/Math.log(10)); 
					counter = 1;
				}
			}
		}
		if(counter == 1)
		{
			newLength += 1;
		}
		else
		{
			newLength += 2 + (int)(Math.log((double)counter)/Math.log(10)); 
			counter = 1;
		}
		return newLength;
	}
	
	public static String compress(String str)
	{
		if(str == null || str.length() == 0 || str.length() == 1)
		{
			return str;
		}
		int newLength = getNewLength(str);
		if(newLength >= str.length())
		{
			return str;
		}
		
		int counter = 1;
		char[] ca = new char[newLength];
		int p = 1;
		ca[0] = str.charAt(0);
		
		
		for(int i = 1; i < str.length(); i++)
		{
			if(str.charAt(i) == str.charAt(i-1))
			{
				++counter;
			}
			else
			{
				if(counter == 1)
				{
					ca[p++] = str.charAt(i);
				}
				else
				{
					String convert = Integer.toString(counter);
					for(int n = 0; n<convert.length(); n++)
					{
						ca[p++] = convert.charAt(n);
					}
					ca[p++] = str.charAt(i);
				}
				counter = 1;
			}
		}
		if(counter > 1)
		{
			String convert = Integer.toString(counter);
			for(int n = 0; n<convert.length(); n++)
			{
				ca[p++] = convert.charAt(n);
			}
		}
		
		return new String(ca);
		
		
	}
	
	
	public static void main(String[] args)
	{
		System.out.println(""+compress("cbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		System.out.println(""+compress("aaaabcccc"));
	}

}
