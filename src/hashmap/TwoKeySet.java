package hashmap;
import java.util.HashSet;
import java.util.HashMap;


public class TwoKeySet<K1, K2>
{
	/*
	 *  A two-key set used to put/get/del two-key pairs in a set
	 *  K1 the data type of key1
	 *  K2 the data type of key2 
	 */
	private int size;
	private HashMap<K1, HashSet<K2>> set;
	
	public TwoKeySet()
	{
		size = 0;
		set = new HashMap<K1, HashSet<K2>>();
	}
	
	@SuppressWarnings("unchecked")
	public TwoKeySet(TwoKeySet<K1, K2> copy)
	{
		this.size = copy.size;
		this.set = (HashMap<K1, HashSet<K2>>)copy.set.clone();
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public void add(K1 key1, K2 key2)
	{
		if(set.containsKey(key1))
		{
			if(!set.get(key1).contains(key2))
				++size;
			set.get(key1).add(key2);
		}
		else
		{
			++size;
			HashSet<K2> subSet = new HashSet<K2>();
			subSet.add(key2);
			set.put(key1, subSet);
		}
	}
	
	public boolean contains(K1 key1, K2 key2)
	{
		if(set.containsKey(key1))
		{
			return set.get(key1).contains(key2);
		}
		else
		{
			return false;
		}
	}
	
	public void remove(K1 key1, K2 key2)
	{
		if(set.containsKey(key1))
		{
			if(set.get(key1).contains(key2))
				--size;
			set.get(key1).remove(key2);
		}
		else
		{
			return;
		}
	}
	
	public void printAll()
	{
		for(K1 key1 : set.keySet())
		{
			for(K2 key2 : set.get(key1))
			{
				System.out.println("(" + key1 + ", " + key2 + ").  ");
			}
		}
	}
	
	public static void main(String[] args)
	{
		TwoKeySet<Integer, Integer> map = new TwoKeySet<Integer, Integer>();
		map.add(0, 0);
		map.add(1, 0);
		map.add(2, 0);
		
		System.out.println(map.contains(1, 0));
		System.out.println(map.contains(1, 2));
		System.out.println(map.contains(2, 2));
		System.out.println(map.contains(1, 3));
		System.out.println(map.contains(5, 3));

	}

}
