package math;

public class Stock3
{

	public static int maxProfit(int[] prices) 
    {
        if(prices.length < 2)
            return 0;
        int[] past = new int[prices.length]; 
        int[] future = new int[prices.length];
        int max = 0;
        
        past[0] = 0;
        int value = prices[0];
        for(int n = 1; n < past.length; n++)
        {
            value = value > prices[n] ? prices[n] : value;
            past[n] = prices[n] - value > past[n-1] ? prices[n] - value : past[n-1];
        }
        System.out.println("PAST:");
        for(Integer i : past)
        	System.out.println("" + i);
        
        
        for(int n = future.length - 1; n >=0; n--)
        {
        	if(n == future.length-1)
        	{
        		future[future.length - 1] = 0;
                value = prices[future.length - 1];
        	}
        	else
        	{
        		value = value < prices[n] ? prices[n] : value;
        		future[n] = future[n+1] < value - prices[n] ? value - prices[n] : future[n+1];
        	}
            max = future[n] + past[n] > max ? future[n] + past[n] : max;
        }
        System.out.println("future:");
        for(Integer i : future)
        	System.out.println("" + i);
        return max;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] a = {2,1,4,5,2,9,7};
		System.out.println(maxProfit(a));
	}

}
