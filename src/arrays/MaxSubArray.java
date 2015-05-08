package arrays;

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
		System.out.println("start: "+maxSub2(a)[0]);
		System.out.println("length: "+maxSub2(a)[1]);
	}




   // range:   [start, end)

    public static int[] maxSub2(int[] a) {
        int currentSum = 0;
        int currentStart = -1;
        int currentEnd = 0;

        int max = Integer.MIN_VALUE;
        int maxStart = 0;
        int maxEnd = 0;

        for (int n = 0; n < a.length; n++) {
            if (currentStart < 0) {
                currentStart = n;
                currentEnd = currentStart;
            }
            currentSum += a[n];
            currentEnd ++ ;
            if (currentSum > max) {
                max = currentSum;
                maxStart = currentStart;
                maxEnd = currentEnd;
            }

            if (currentSum < 0) {
                currentStart = -1;
                currentSum = 0;
            }
        }

        int[] res = new int[2];
        res[0] = maxStart;
        res[1] = maxEnd - 1;
        return res;
    }



























}
