package sort;

import java.util.Random;

public class SortAlgs
{

	public static void mergeSort(int[] a)
	{
		mergeSort(a, 0, a.length-1);	
	}
	
	
	public static int partition(int[] list, int first, int last) 
	{
		if(last < first)
			return -1;
		if(last == first)
			return first;
		
		Random random = new Random();
		int pivot = first + random.nextInt(last - first + 1);
		//int pivot = 2;
		System.out.println("pivot" + pivot);
		swap(list, first, pivot);
		
		int low = first + 1;
		int high = last;
		
		while(high > low)
		{
			while(high > low && list[low] < list[first])
				++low;
			while(high > low && list[high] >= list[first])
				--high;
			if(high > low)
			{
				swap(list, high, low);
				++low;
				--high;
			}
		}
		/*
		 * The first case is that: 
		 * high and low missed each other by swap and ++low, --high.
		 * then , we could be sure that the position of high is the right position for pivot.
		 */
		if(list[high] < list[first] && low > high)
		{
			swap(list, high, first);
			return high;
		}
		/*
		 *  low and high went together in some cases
		 */
		else
		{
			//check from right to left to find the proper position for pivot.
			while(high > first && list[high] >= list[first])
				--high;
			if(high == first)
			{
				return first;
			}
			//if first is reached that means list[first] is the lowest one in the current 
			//ranges and thus does not need to be swapped
			else
			{
				swap(list, first, high);
				return high;
			}
		}
	}
	
	
	
	private static void mergeSort(int[] a, int low, int high)
	{
		if(low >= high)
			return;
		
		int mid = low + (high - low) / 2;
		
		mergeSort(a, low, mid);
		
		mergeSort(a, mid+1, high);
		
		merge(a, low, mid, high);
	}
	
	
	public static void merge(int[] a, int low, int mid, int high)
	{
		int[] auk = new int[a.length];
		
		int i = low;
		int j = mid+1;
		
		for(int n = low; n <= high; n++)
		{
			auk[n] = a[n];
		}
		
		for(int n = low; n <= high; n++)
		{
			if(i > mid)
				a[n] = auk[j++];
			else if(j>high)
				a[n] = auk[i++];
			else if(auk[i] < auk[j])
				a[n] = auk[i++];
			else
				a[n] = auk[j++];
		}	
	}
	
	private static void swap(int a[], int x, int y)
	{
		System.out.println("swap : " + x + ", " + y);
		if(x == y)
			return;
		a[x] = a[x]^a[y];
		a[y] = a[x]^a[y];;
		a[x] = a[x]^a[y];
	}
	
	
	
	public static void quicksort(int a[], int left, int right)
	{
		System.out.println("left " + left + "\t right "+ right);
		show(a);
		
		if(left >= right)
			return;
		int p = partition(a, left, right);
		quicksort(a, left, p-1);
		quicksort(a, p + 1, right);
	}
	
	public static void show(int[] a)
	{
		for(int n = 0; n < a.length; n++)
			System.out.print("a["+n+"] = "+ a[n]+"\t");
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		int[] a = {2,1,3,6,9};
		//quicksort(a,0,a.length-1);
		//System.out.println(partition(a, 0, 2));
		quicksort(a, 0, a.length -1);
		show(a);
		
	}

}
