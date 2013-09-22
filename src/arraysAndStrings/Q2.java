package arraysAndStrings;
import basicAlg.ToolKit;

public class Q2
{

	/**
	 * Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five characters, including the null character.)
	 * 
	 * I implement this with Java String
	 */
	
	
	public static String reverse(String str)
	{
		char[] a = str.toCharArray();
		
		int start = 0;
		int end = a.length-1;
		while(end > start)
		{
			ToolKit.swap(a,end,start);
			--end;
			++start;
		}
		return new String(a);
		
	}
	
	public static void main(String[] args)
	{
		System.out.println(reverse("hello, world"));
	}

}
