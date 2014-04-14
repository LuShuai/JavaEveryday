package someTest;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSets2
{

	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) 
    {
        if(num == null || num.length == 0)
            return null;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int n = num.length - 1; n >= 0; n--)
        {
        	System.out.println("check: " + num[n] );
            //non-duplication
            if(n == num.length - 1 || num[n] != num[n+1])
            {
            	System.out.println("new");
                temp = new ArrayList<ArrayList<Integer>>();
                for (int j = 0; j < res.size(); j++) {
    				temp.add(new ArrayList<Integer>(res.get(j)));
    			}
                
                
                System.out.println("temp:");
                print(temp);
                //add num[n] to the previous lists
                for(ArrayList<Integer> list : temp)
                {
                	System.out.println("****Add***" + num[n]);
                    list.add(0,num[n]);
                }
                //add num[n] itself as a list
                ArrayList<Integer> single = new ArrayList<Integer>();
                single.add(num[n]);
                temp.add(single);
            }
            //duplication
            else
            {
            	System.out.println("Not New");
            	System.out.println("temp:");
            	print(temp);
            	print(res);
                for(ArrayList<Integer> list : temp)
                {
                	System.out.println("****Add***" + num[n]);
                    list.add(num[n]);
                }
            }
            System.out.println("result befor");
            print(res);
            for(ArrayList<Integer> list : temp)
            {
                res.add(new ArrayList<Integer>(list));
            }
            
            System.out.println("result");
            print(res);
        }
        res.add(new ArrayList<Integer>());
        return res;
    }
	
	public static void main(String[] args)
	{
		int[] a = {1,2};
		ArrayList<ArrayList<Integer>> res = subsetsWithDup(a);
		/*
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> lvl = new ArrayList<Integer>();
		lvl.add(2);
		res.add(lvl);
		print(res);
		for(ArrayList<Integer> l : res)
			l.add(2);
		*/
		print(res);
	}
	
	public static void print(ArrayList<ArrayList<Integer>> res)
	{
		for(ArrayList<Integer> l : res)
		{
			System.out.print("[");
			for(int n = 0; n < l.size(); n++)
			{
				if(n == l.size() - 1)
					System.out.print(l.get(n));
				else
					System.out.print(l.get(n) + ", ");
			}
			System.out.print("]");
		}
		System.out.println();
	}
}
