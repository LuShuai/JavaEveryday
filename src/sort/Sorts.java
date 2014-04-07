package sort;

import java.util.Random;

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
		if(a == b)
			return ;
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
		if(start >= end)
			return ;
		int pivot = partition2(a,start,end);
		quickSort(a,start,pivot-1);
		quickSort(a,pivot+1,end);
	}
	
	private static int partition(int a[], int start, int end)
	{
		if(start == end)
			return start;
		
		Random random = new Random();
		int pivot = start + random.nextInt(end - start + 1);
		swap(a,start,pivot);
		
		int left = start+1;
		int right = end;
		while(left < right)
		{
			while(left<right && a[left] < a[start])
				++left;
			while(left<right && a[right] >= a[start])
				--right;
			if(right > left)
			{
				swap(a,left,right);
				++left;
				--right;
			}
		}
		
		if(right < left && a[right] < a[start])
		{
			swap(a,right,start);
			return right;
		}
		else
		{
			while(right > start && a[right] >= a[start])
			{
				--right;
			}
			if(right == start)
				return start;
			else
			{
				swap(a, start, right);
				return right;
			}
		}
	}
	
	private static int partition2(int[] a, int start, int end)
	{
		if(start == end)
			return start;
		if(start > end)
			return -1;
		
		Random random = new Random();
		int pivot = start + random.nextInt(end - start + 1);
		swap(a, start, pivot);
		
		int left = start + 1;
		int right = end;
		
		while(right > left)
		{
			while(left < right && a[left] < a[start])
				left ++;
			while(left < right && a[right] >= a[start])
				right --;
			if(left < right)
			{
				swap(a,left, right);
				right--;
				left++;
			}
		}
		
		if(left > right && a[right] < a[start])
		{
			swap(a, right, start);
			return right;
		}
		else
		{
			while(right > start && a[right] >= a[start])
				right --;
			if(right > start)
			{
				swap(a, right, start);
				return right;
			}
			else
				return start;
		}
	}
	
	public static void print(int[] a)
	{
		for(int n = 0; n<a.length; n++)
			System.out.print("["+a[n]+"]");
		System.out.print("\n");			
	}
	
	public static void main(String[] args)
	{
		//int[] a = {1,4,3,6,7};
		int[] a = {3,1,9,2,6};
		print(a);
		quickSort(a);
		print(a);
	}
	

}
