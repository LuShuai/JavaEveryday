package arraysAndStrings;

public class MaxSubArray
{

	public static int[] maxSub(int[] a)
	{
		int[] result = new int[2];
		int currentMax = 0;
		int currentBegin = -1;
		int currentLength = 0;
		int max = Integer.MIN_VALUE;
		int maxBegin = -1;
		int maxLength = -1;
		
		for(int n = 0; n < a.length; n++)
		{
			currentMax = currentMax + a[n];
			
			if(currentBegin < 0) //current Begin has not been initialed
			{
				currentBegin = n;
				currentLength = 0;
			}
			
			++currentLength;
			//max = Math.max(max, currentSum);
			if(currentMax >= max)
			{
				
				max = currentMax;
				maxBegin = currentBegin;
				maxLength = currentLength;
			}
				
			//currentSum = Math.max(0, currentSum);
			if(currentMax < 0)
			{
				//set all of them to initial state
				currentMax = 0;
				currentBegin = -1;
				currentLength = 0;
			}
		}
		result[0] = maxBegin;
		result[1] = maxLength;
		return result;
	}
	
	public static void main(String[] args)
	{
		//int[] a = {-5,-1,1,2,-10,2,-1,3};
		int[] a = {1,2,3,4,-100,10,-1,2};
		System.out.println("start: "+maxSub(a)[0]);
		System.out.println("length: "+maxSub(a)[1]);
	}

}
