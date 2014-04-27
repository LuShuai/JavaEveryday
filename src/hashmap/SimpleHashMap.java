package hashmap;

import java.util.LinkedList;

public class SimpleHashMap<K, V>
{

	/**
	 *  A simple HashMap implementation with generic type
	 *  use LinkedList in java.util as the bucket
	 */
	private static final int INIT_CAPACITY = 10;
	
	private int number;
	private int capacity;
	private LinkedList<MyEntry<K, V>>[] buckets;
	
	@SuppressWarnings("unchecked")
	public SimpleHashMap(int cap)
	{
		number = 0;
		this.capacity = cap;
		buckets = (LinkedList<MyEntry<K, V>>[])new LinkedList[cap];
		for(int n = 0; n < buckets.length; n++)
			buckets[n] = new LinkedList<MyEntry<K,V>>();
	}
	
	public SimpleHashMap()
	{
		this(INIT_CAPACITY);
	}
	
	private int hash(K key)
	{
		return (key.hashCode() & 0x7fffffff) % capacity;
	}
	
	public V get(K key)
	{
		int index = hash(key);
		for(MyEntry<K, V> entry : buckets[index])
		{
			if(entry.getKey().equals(key))
				return entry.getValue();
		}
		return null;
	}
	
	public boolean isEmpty()
	{
		return number == 0;
	}
	
	public boolean containsKey(K k)
	{
		return get(k) != null;
	}
	
	public int size()
	{
		return number;
	}
	
	private void resize(int newSize)
	{
		SimpleHashMap<K ,V> temp = new SimpleHashMap<K, V>(newSize);
		for(int n = 0; n < buckets.length; n++)
			for(MyEntry<K, V> entry : buckets[n])
				temp.put(entry.getKey(), entry.getValue());
		this.number = temp.number;
		this.capacity = temp.capacity;
		this.buckets = temp.buckets;
	}
	
	public void put(K key, V val)
	{
		if(val == null)
		{
			delete(key);
			return;
		}
		int index = hash(key);
		for(MyEntry<K,V> entry : buckets[index])
		{
			if(entry.getKey().equals(key))
			{
				entry.setValue(val);
				return;
			}
		}
		buckets[index].add(new MyEntry<K, V>(key, val));
		number++;
		if(number >= capacity)
		{
			resize(capacity * 2);
		}
	}
	
	public void delete(K key)
	{
		int index = hash(key);
		for(int n = 0; n < buckets[index].size(); n++)
		{
			if(buckets[index].get(n).getKey().equals(key))
			{
				buckets[index].remove(n);
				number--;
				if(number < capacity/2 && capacity/2 >= INIT_CAPACITY)
				{
					resize(capacity/2);
				}
				return;
			}
		}
	}
	
	public Iterable<K> keySet()
	{
		LinkedList<K> keys = new LinkedList<K>();
		for(int n = 0; n < buckets.length; n++)
			for(MyEntry<K, V> entry : buckets[n])
				keys.add(entry.getKey());
		return keys;
	}
	
	public static void main(String[] args)
	{
		SimpleHashMap<Integer, Integer> test = new SimpleHashMap<Integer, Integer>();
		test.put(1,3);
		System.out.println(test.get(1));
	}
	
}
