package someTest;

import java.util.ArrayList;
/*
 * Find common subset of two sorted
 * integer array with O(N) time and
 * O(1) space
 * 
 */

public class FindCommonSubset
{
	public static ArrayList<Integer> getCommon(int[] a, int[] b)
	{
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(a == null || b == null || a.length == 0 || b.length == 0)
			return res;
		int aRunner = 0;
		int bRunner = 0;
		
		while(aRunner < a.length && bRunner < b.length)
		{
			if(a[aRunner] == b[bRunner])
			{
				res.add(a[aRunner]);
				++aRunner;
				++bRunner;
			}
			else if(a[aRunner] > b[bRunner])
			{
				++bRunner;
			}
			else
			{
				++aRunner;
			}
		}
		return res;
	}
	
	public static void print(ArrayList<Integer> res)
	{
		System.out.print("[ ");
		for(Integer i : res)
		{
			System.out.print(i + ", ");
		}
		System.out.println("]");
	}
	
	public static void main(String[] args)
	{
		int[] a = {1,2,4,5,7,8};
		int[] b = {0,3,5,8};
		
		print(getCommon(a,b));
		

	}

}
