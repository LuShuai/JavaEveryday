package sort;

import java.util.ArrayList;
import java.util.Random;

public class FindKth
{
	private static final boolean D = false;
	//param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public static int kthSmallestElement(int k, ArrayList<Integer> numbers) {
       return kthSmallestElement(k, numbers, 0, numbers.size() - 1);
    }
    
    public static int kthLargestElement(int k, ArrayList<Integer> numbers) {
        return kthLargestElement(k, numbers, 0, numbers.size() - 1);
     }
    
    private static int kthSmallestElement(int k,ArrayList<Integer> numbers, int start, int end) {
        int index = partition(numbers, start, end);
        if(D) {
        print(numbers);
        System.out.println("find : " + k + "    in start: " +start + ",    end: " + end);
        System.out.println("index = " + index);
        }
        if (index - start + 1 > k) {
            return kthSmallestElement(k, numbers, start, index - 1);
        }
        else if (index - start + 1 < k ){
            return kthSmallestElement(k- (index -start + 1), numbers, index + 1, end);
        }
        else {
            return numbers.get(index);
        }
    }
    
    private static int kthLargestElement(int k,ArrayList<Integer> numbers, int start, int end) {
        int index = partition(numbers, start, end);
        if(D) {
        print(numbers);
        System.out.println("find : " + k + "    in start: " +start + ",    end: " + end);
        System.out.println("index = " + index);
        }
        if (end - index + 1 > k) {
            return kthLargestElement(k, numbers, index + 1, end);
        }
        else if (end - index + 1 < k ){
            return kthLargestElement(k- (end - index + 1), numbers, start, index -1);
        }
        else {
            return numbers.get(index);
        }
    }
    
    private static int partition(ArrayList<Integer> numbers, int left, int right) {
        if (left > right) {
            return -1;
        }
        if(left == right)
        	return left;
        //set pivot
        Random random = new Random();
        int pivot = left + random.nextInt(right - left + 1);
        swap(numbers, left, pivot);
        //swaping numbers
        int low = left + 1;
        int high = right;
        while(high > low) {
            while(high > low && numbers.get(high) >= numbers.get(left))
                --high;
            while(high > low && numbers.get(low) < numbers.get(left))
                ++low;
            if (high > low) {
                swap(numbers, high, low);
                ++low;
                --high;
            }
        }
        //find postion of pivot
        if (low > high && numbers.get(high) < numbers.get(left)) {
            swap(numbers, left, high);
            return high;
        }
        else {
            while(high > left && numbers.get(high) >= numbers.get(left)) {
                --high;
            }
            if (high == left) {
                return left;
            }
            else{
                swap(numbers, high, left);
                return high;
            }
        }
        
    }
    
    public static void print(ArrayList<Integer> al) {
    	System.out.print("[ ");
    	for(Integer n : al) {
    		System.out.print(n + ", ");
    	}
    	System.out.println("]");
    }
    
    private static void swap(ArrayList<Integer> numbers, int a, int b) {
        int temp = numbers.get(a);
        numbers.set(a, numbers.get(b));
        numbers.set(b, temp);
    }
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,6,8,9,10,7};
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(Integer i : a)
			al.add(i);
		System.out.println(kthLargestElement(10,al));
	}

}
