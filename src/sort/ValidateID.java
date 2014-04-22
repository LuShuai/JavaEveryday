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
			//put the number in the start position into 'hand'
			int start = current;	
			int inHand = a[start]; 
			while(start != inHand-1)
			{
				//the number in hand is not valid
				if(inHand > a.length || inHand < 1 || a[inHand-1] == inHand)
				{
					return false;
				}
				else
				{
					//put the number in hand into the proper position and get a new number in
					//that position into hand
					int temp = a[inHand-1];
					a[inHand-1] = inHand;
					inHand = temp;
				}
			}
			//put the number in hand into start position
			a[start] = inHand;
			++current;
		}
		return true;
	}
	
	
	public static void main(String[] args)
	{
		int[] a = {1,2,3};
		System.out.println(valid(a));
	}

}
