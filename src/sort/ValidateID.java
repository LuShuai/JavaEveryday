package sort;

public class ValidateID
{

	/**
	 * @ Validate a array of numbers,
	 * find out that whether they a increasingly from 1 to N.
	 */
	public static boolean valid(int[] a)
	{
		int current = 0;
		while(current < a.length)
		{
			int start = current;	
			int inHand = a[start]; 
			while(start != inHand-1)
			{
				if(inHand > a.length || inHand < 1 || a[inHand-1] == inHand)
				{
					return false;
				}
				else
				{
					int temp = a[inHand-1];
					a[inHand-1] = inHand;
					inHand = temp;
				}
			}
			int temp = a[start];
			a[start] = inHand;
			++current;
		}
		return true;
	}
	
	
	public static void main(String[] args)
	{
		int[] a = {4,5,3,2,1,9};
		System.out.println(valid(a));
	}

}
