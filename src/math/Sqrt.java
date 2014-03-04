package math;

public class Sqrt
{

	
	public static long sqrt2(int x) {
		 long i = 0;
		 long j = x / 2 + 1;
		 while (i <= j)
		 {
		 long mid = (i + j) / 2;
		 long sq = mid * mid;
		 if (sq == x) 
			 return mid;
		 else if (sq < x) i = mid + 1;
		 else j = mid - 1;
		}
		return j;
		}
	
	public static int sqrt(int x) 
    {
        if(x == 0)
            return 0;
        //binary search
        int i = 0;
        int j = x/2 + 1;
        int mid;
        while(j>=i)
        {
        	System.out.println("i = " + i + "\tj = " + j);
            mid = (j+i)/2;
            long sqrt = mid * mid;
            if(sqrt == x)
                return mid;
            if(sqrt > x)
            {
                j = mid - 1;
            }
            else
            {
                i = mid + 1;
            }
        }
        return j;
    }
	
	public static void main(String[] args)
	{
		System.out.println(""+sqrt(2147483647));
	}

}
