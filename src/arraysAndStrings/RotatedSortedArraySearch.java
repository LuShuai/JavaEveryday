package arraysAndStrings;

public class RotatedSortedArraySearch
{

	public static boolean search(int[] A, int target) 
    {
        return search(A, target, 0, A.length-1);
    }
    
    private static boolean search(int A[], int target, int left, int right)
    {
        if(left > right)
            return false;
        
        int mid = (left+right)/2;
        
        if(A[mid] == target || A[left] == target || A[right] == target)
            return true;
        
        else if(A[mid] > target)
        {
            if(A[left] > A[mid])
                return search(A, target, left, mid-1);
            else if(A[left] < A[mid])
            {
                if(A[right] > target)
                    return search(A, target, left, mid-1);
                else if(A[right] < target)
                    return search(A, target, mid+1, right);
                else
                    return true;
            }
            else // left = mid
            {
                return search(A, target, mid+1, right);
            }
        }
        else // mid < target
        {
            if(A[right] < A[mid])
                return search(A, target, mid+1, right);
            else if(A[right] > A[mid])//right > mid
            {
                if(A[left] < target)
                    return search(A, target, left, mid -1);
                else if(A[left] > target)
                    return search(A, target, mid+1, right);
                else
                    return true;
            }
            else //right = mid
            {
                return search(A, target, left, mid -1);
            }
        }
    }
	
	public static void main(String[] args)
	{
		int[] a= {1,1,3,1};
		System.out.println(search(a, 1));

	}

}
