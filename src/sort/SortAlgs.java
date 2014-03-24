package sort;

public class SortAlgs
{

	public static void mergeSort(int[] a)
	{
		mergeSort(a, 0, a.length-1);	
	}
	
	
	private static int partition(int[] list, int first, int last) {
	    int pivot = list[first];
	    int low = first + 1;
	    int high = last;

	    while (high > low) {

	        while (low < high && list[low] < pivot) {
	            low++;
	        }


	        while (low < high && list[high] >= pivot) {
	            high--;
	        }


	        if (high > low) {
	            int temp = list[high];
	            list[high] = list[low];
	            list[low] = temp;
	        }
	    }
	    while (high > first && list[high] >= pivot) {
	        high--;
	    }

	    if (pivot > list[high]) {
	        list[first] = list[high];
	        list[high] = pivot;
	        return high;
	    } else {
	        return first;
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
		a[x] = a[x]^a[y];
		a[y] = a[x]^a[y];;
		a[x] = a[x]^a[y];
	}
	
	
	
	public static void quicksort(int a[], int left, int right)
	{
		int i = left;
		int j = right;
		int m = (i+j)/2;
		int pivot = a[m];
		
		while(i <= j)
		{
			while(a[i] < pivot)
				i++;
			while(pivot < a[j])
				j--;
			if(i <= j)
			{
				swap(a,j,i);
			}
			i++;
			j--;
		}
		
		if(left < j)
			quicksort(a, left, j);
		if(i < right)
			quicksort(a, i, right);
	}
	
	public static void show(int[] a)
	{
		for(int n = 0; n < a.length; n++)
			System.out.print("a["+n+"] = "+ a[n]+"\t");
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		int[] a = {3,1,9,2,6};
		quicksort(a,0,a.length-1);
		show(a);
	}

}
