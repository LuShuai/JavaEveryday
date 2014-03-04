package arraysAndStrings;

public class SearchA2Darray
{
	
	public static boolean searchMatrix(int[][] matrix, int target) 
    {
        int row = getRowNum(matrix, target);
        return binarySearch(matrix[row], target, 0, matrix[row].length-1);
    }
    
    private static int getRowNum(int[][] matrix, int target)
    {
        int up = 0;
        int low = matrix.length-1;
        int mid = (up + low) / 2;
        while(up < low)
        {
            if(mid == matrix.length-1 || ( matrix[mid][0] < target && matrix[mid+1][0] > target) || matrix[mid][0] == target )
            {
                return mid;
            }
            else
            {
                if(matrix[mid][0] < target && matrix[mid+1][0] < target)
                    up = mid + 1;
                else if(matrix[mid][0] > target && matrix[mid+1][0] > target)
                    low = mid -1;
            }
        }
        return matrix.length-1;
    }
    
    
    //search in a row
    private static boolean binarySearch(int[] A, int target, int left, int right)
    {
    	/*
        if(left > right)
            return false;
        int mid = left + (right - left)/2;
        
        if(A[mid] == target)
            return true;
        else if(A[mid] > target)
            return binarySearch(A, target, left, mid - 1);
        else
            return binarySearch(A, target, mid+1, right);
            */
    	int mid;
        while(left < right)
        {
            mid = left + (right - left)/2;
            if(A[mid] == target)
                return true;
            else if(A[mid] > target)
                right = mid -1;
            else
                left = mid + 1;
        }
        return false;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[][] a = {{1,3}};
		System.out.println(""+ searchMatrix(a,1));

	}

}
