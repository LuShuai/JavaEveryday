package someTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ThreeList
{

	public static LinkedList<Integer> addToC(List<Integer> a, List<Integer> b)
	{
		HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
		LinkedList<Integer> result = new LinkedList<Integer>(); 
		for(Integer i : a)
		{
			if(hash.containsKey(i) && !result.contains(i))
			{
				result.add(i);
			}
			else
			{
				hash.put(i, true);
			}
		}
		
		for(Integer i : b)
		{
			if(hash.containsKey(i) && !result.contains(i))
			{
				result.add(i);
			}
			else
			{
				hash.put(i, true);
			}
		}
		
		return result;
		
	}

	public static void main(String[] args)
	{
		List<Integer> a = new LinkedList<Integer>();
		List<Integer> b = new LinkedList<Integer>();
		a.add(1); 
		a.add(3);
		a.add(3);
		a.add(5);
		a.add(7);
		
		b.add(2);
		b.add(4);
		b.add(5);
		b.add(6);
		b.add(8);
		b.add(8);
		b.add(8);
		
		LinkedList<Integer> c = addToC(a, b);
		for(Integer i : c)
		{
			System.out.println(""+i);
		}
		

	}

}
