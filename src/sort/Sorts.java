package sort;

public class Sorts
{
	public static void insertionSort(int[] a)
	{
		for(int n = 0; n < a.length; n++)
			for(int k = 0; k<a.length-n-1; k++)
				if(a[k]>a[k+1])
					swap(a,k,k+1);
	}
	
	private static void swap(int num[], int a, int b)
	{
		num[a] = num[a]^num[b];
		num[b] = num[a]^num[b];
		num[a] = num[a]^num[b];
	}
	
	public static void quickSort(int[] a)
	{
		quickSort(a, 0, a.length-1);
	}
	
	private static void quickSort(int[] a, int start, int end)
	{
		System.out.println("sort:"+start+" to "+end);
		if(start == end )
		{
			return;
		}
		int low = start+1;
		int hi = end;
		while(hi>low)
		{
			while(a[hi]>a[start] && low < hi)
			{
				--hi;
			}
			while(a[low] < a[start] && low < hi)
			{
				++low;
			}
			if(hi!=low)
			{
				System.out.println("swap: "+ low+", "+hi);
				swap(a,low,hi);
				--hi;
				++low;
			}
		}
		if(a[low] < a[start])
		{
			swap(a,low,start);
			System.out.println("!swap: "+ start+", "+low);
			quickSort(a,start,low-1);
			quickSort(a,low+1,end);
		}
		else
			quickSort(a, start+1,end);
	}
	
	public static void print(int[] a)
	{
		for(int n = 0; n<a.length; n++)
			System.out.print("["+a[n]+"]");
		System.out.print("\n");			
	}
	
	public static void main(String[] args)
	{
		int[] a = {1,4,3,6,7};
		print(a);
		quickSort(a);
		print(a);
	}
	

}
