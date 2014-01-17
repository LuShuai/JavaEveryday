package arraysAndStrings;

public class DoubleAndReverse
{

	public static void doubleRverseShow(String str)
	{
		int size = str.length();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++)
		{
			char[] ca = str.toCharArray();
			for(int n = 0; n < str.length()-1; n++)
			{
				sb.append(ca[n]);
				sb.append(ca[n]);
			}
			StringBuilder rsb = sb.reverse();
			sb.append(rsb);
			str = new String(sb);
			System.out.println(str);
		}
	}
	
	
	public static void main(String[] args)
	{
		doubleRverseShow("abcd");

	}

}
