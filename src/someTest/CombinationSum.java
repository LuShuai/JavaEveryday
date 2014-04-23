package someTest;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum
{
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) 
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        DFS(candidates, 0, target, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    public static void DFS(int[] candidates, int start, int target, int curVal, ArrayList<Integer> curList, ArrayList<ArrayList<Integer>> res)
    {
        if(curVal == target)
        {
        	System.out.println("save to list");
            res.add(new ArrayList<Integer>(curList));
            return;
        }
        for(int n = start; n < candidates.length; n++)
        {
            if(curVal + candidates[n] > target)
                break;
            System.out.println("add" + candidates[n]);
            curList.add(candidates[n]);
            DFS(candidates, n, target, curVal + candidates[n], curList, res);
            //curList.remove(curList.size() - 1);
        }
    }
	
	public static void main(String[] args)
	{
		int[] a = {1};
		System.out.println(combinationSum(a,1));
	}

}
