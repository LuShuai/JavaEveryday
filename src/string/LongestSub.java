package string;

import java.util.Hashtable;

public class LongestSub
{
	public static String longestSub(String str)
	{
		Hashtable<Character,Boolean> hash = new Hashtable<Character,Boolean>();
		int maxLength = 0;
		int currentLength = 0;
		StringBuilder sb = new StringBuilder();
		StringBuilder maxStr = new StringBuilder();
		for(int n = 0; n < str.length(); n++)
		{
			if(hash.containsKey ( str.charAt(n) ) )
			{
				if(currentLength > maxLength)
				{
					maxLength = currentLength;
					maxStr = new StringBuilder(sb);
					System.out.println(maxStr);
				}
				hash.clear();
				hash.put(str.charAt(n), true);
				currentLength = 1;
				sb.delete(0, sb.length());
				sb.append(str.charAt(n));
			}
			else
			{
				hash.put(str.charAt(n), true);
				sb.append(str.charAt(n));
				++currentLength;
			}
		}
		if(currentLength > maxLength)
		{
			maxLength = currentLength;
			maxStr = sb;
		}
		
		return new String(maxStr);
	}

	
	public static void main(String[] args)
	{
		System.out.println(longestSub("abcabcbb"));

	}

}
