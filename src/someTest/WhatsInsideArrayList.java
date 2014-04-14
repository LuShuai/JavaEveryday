package someTest;
import java.util.ArrayList;

public class WhatsInsideArrayList
{
	
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
	
	
	public static void main(String[] args)
	{
		ArrayList<ArrayList<Integer>> outerList1 = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> innerList1 = new ArrayList<Integer>();
		ArrayList<Integer> innerList2 = new ArrayList<Integer>();
		ArrayList<Integer> innerList3 = new ArrayList<Integer>();
		
		innerList1.add(1);
		innerList1.add(2);
		
		innerList2.add(2);
		innerList2.add(3);
		
		innerList3.add(4);
		innerList3.add(5);
		
		outerList1.add(innerList1);
		outerList1.add(innerList2);
		outerList1.add(innerList3);
		
		print(outerList1);
		
		//ArrayList<ArrayList<Integer>> outerList2 = new ArrayList<ArrayList<Integer>>();
		/*
		for(ArrayList<Integer> list : outerList1)
		{
			outerList2.add(list);
		}
		*/
		ArrayList<ArrayList<Integer>> outerList2 = new ArrayList<ArrayList<Integer>>(outerList1);
		outerList1.get(0).add(1);
		outerList1.get(0).set(0, 100);
		
		Integer a = outerList1.get(0).get(0);
		
		print(outerList1);
		print(outerList2);

	}

}
