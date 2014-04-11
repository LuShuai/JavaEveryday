package hashmap;

import java.util.LinkedList;

public class ChainingHashMap<K, V> implements myMap<K, V>
{
	private static final int INIT_CAPACITY = 4;
	int capacity;
	int pair_num;
	
	Chain<K, V>[] buckets;

	ChainingHashMap()
	{
		this(INIT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	ChainingHashMap(int init_capacity)
	{
		capacity = init_capacity;
		buckets = (Chain<K, V>[])new Chain[capacity];
	}
	
	
	@Override
	public void put(Object key, Object value)
	{
		
		
	}

	@Override
	public V get(Object key)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Object key)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty()
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void resize(int size)
	{
		
	}

	@Override
	public boolean contains(Object key)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
