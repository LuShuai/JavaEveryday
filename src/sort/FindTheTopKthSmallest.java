package sort;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

public class FindTheTopKthSmallest
{
	
	public static void print(int[] a)
	{
		for(Integer i : a)
			System.out.print("[" +i + "],");
		System.out.println();
	}
	public static void print(int[] a, int start, int end)
	{
		for(int n = start; n<=end; n++)
			System.out.print("[" +a[n] + "],");
		System.out.println();
	}
	
	
	public static int partition(int[] list, int first, int last) 
	{
		if(list.length == 1)
			return first;
		Random random = new Random();
		int pivot = first + random.nextInt(last - first + 1);
		swap(list, pivot, first);
	    int low = first + 1;
	    int high = last;

	    while (high > low) 
	    {
	        while (low < high && list[low] < list[first]) 
	        {
	            low++;
	        }
	        while (low < high && list[high] >= list[first]) 
	        {
	            high--;
	        }
	        if (high > low) 
	        {
	        	swap(list, low, high);
	        	++low;
	        	--high;
	        }
	    }
	    if(list[high] < list[first] && low > high)
	    {
	    	swap(list, first, high);
	    	return high;
	    }
	    else
	    {
	    	while(high > first && list[high] >= list[first]  )
	    	{
	    		--high;
	    	}
	    	if(high > first)
	    	{
	    		swap(list, first, high);
	    		return high;
	    	}
	    	else
	    	{
	    		return first;
	    	}
	    }
	}
	
	private static void add(LinkedList<Integer> set, int[] a, int start, int end)
	{
		//System.out.println("add " + start + " to " + end);
		for(int n = start; n <= end; n++)
			set.add(a[n]);
	}
	
	public static void getTheTopK(int[] a, int k, int start, int end, LinkedList<Integer> res)
	{
		if(k > end - start + 1)
		{
			System.out.println("error");
			return;
		}
		
		int pivot = partition(a, start, end);
		//System.out.println("pivot" + (pivot - start));
		if((pivot - start + 1) > k)
		{
			getTheTopK(a, k, start, pivot, res);
		}
		else if((pivot - start + 1) < k)
		{
			add(res, a, start, pivot);
			getTheTopK(a, k - (pivot-start +1), pivot+1, end, res);
		}
		else
		{
			add(res, a, start, pivot);
		}
	}
	
	private static void swap(int[] a, int x, int y)
	{
		//System.out.println("swap: " + x + ", " + y);
		if(x == y)
			return;
		a[x] = a[x]^a[y];
		a[y] = a[x]^a[y];
		a[x] = a[x]^a[y];
	}
	
	
	public static void main(String[] args)
	{
		int a[] = {2,1,3,6,9};
		LinkedList<Integer> set = new LinkedList<Integer>(); 
		getTheTopK(a, 2,0, a.length-1, set);
		//System.out.println("[" + partition(a, 0, 2) + "]");
		print(a);
		System.out.print("result: \n");
		for(Integer i : set)
			System.out.println(i);
	}

}
