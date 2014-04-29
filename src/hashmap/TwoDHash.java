package hashmap;

import java.util.HashMap;


/*
 *  The 2D hash in my code base
 *  K1 is the data type of the first dimension
 *  K2 is the data type of the second dimension
 *  V is the data type of the value stored in the map
 * 
 */

public class TwoDHash<K1, K2, V>
{
	//debuging mod
	private final boolean D = false;
	int size;
	HashMap<K1, HashMap<K2, V>> map;

	//constructor
	public TwoDHash()
	{
		map = new HashMap<K1, HashMap<K2, V>>();
		size = 0;
	}
	
	
	public int size()
	{
		return size;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	public boolean containsKey(K1 key1, K2 key2)
	{
		return get(key1, key2) != null;
	}

	public V get(K1 key1, K2 key2)
	{
		if(D)
			System.out.println("get: " + key1 + ", " + key2);
		if(map.containsKey(key1))
		{
			return map.get(key1).get(key2);
		}
		else
		{
			return null;
		}
	}

	public void put(K1 key1, K2 key2, V value)
	{
		if(D)
			System.out.println("put: " + key1 + ", " + key2);
		if(value == null)
		{
			remove(key1, key2);
			return ;
		}
		if(map.containsKey(key1))
		{
			if(!map.get(key1).containsKey(key2))
				++size;
			map.get(key1).put(key2, value);
		}
		else
		{
			++size;
			HashMap<K2, V> sub = new HashMap<K2, V>();
			sub.put(key2, value);
			map.put(key1, sub);
		}
	}

	public void remove(K1 key1, K2 key2)
	{
		if(map.containsKey(key1))
		{
			if(map.get(key1).containsKey(key2))
			{
				--size;
				map.get(key1).remove(key2);
				//do not need to handle key1 here because it is valid for the outer keys to be mapping to a empty HashMap
			}
			else
			{
				//no key2 exists
				return;
			}
		}
		else
		{
			//no key1 exists
			return;
		}
	}

	public void clear()
	{
		TwoDHash<K1, K2, V> temp = new TwoDHash<K1, K2, V>();
		this.map = temp.map;
		this.size = temp.size;
	}
	
	public static void main(String[] args)
	{
		TwoDHash<Integer, Integer, String> map = new TwoDHash<Integer, Integer, String>();
		map.put(1, 1, "Hello");
		map.put(1, 2, ",");
		map.put(0, 1, "World");
		map.put(0, 2, "!");
		
		for(int m = 1; m >=0; m--)
			for(int n = 1; n <=2; n++)
				System.out.println(map.get(m, n));
	}
}
