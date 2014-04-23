package hashmap;

import java.util.LinkedList;
import java.util.Queue;

public class HashWithSeparateChaining<K, V>
{
	private static final int INIT_CAPACITY = 10;
	
	private int number;
	private int capacity;
	private Chain<K, V>[] buckets;
	
	public HashWithSeparateChaining()
	{
		this(INIT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public HashWithSeparateChaining(int n)
	{
		capacity =  n;
		buckets = (Chain<K, V>[]) new Chain[n];
		for(int i = 0; i < n; i++)
			buckets[i] = new Chain<K, V>();
	}
	
	private void resize(int chains)
	{
		HashWithSeparateChaining<K, V> temp = new HashWithSeparateChaining<K, V>(chains);
		for(int i = 0; i < buckets.length; i++)
		{
			for(K key : buckets[i].keys())
				temp.put(key, buckets[i].get(key));
		}
		this.number = temp.number;
		this.capacity = temp.capacity;
		this.buckets = temp.buckets;
	}
	
	private int hash(K key)
	{
		return (key.hashCode() & 0x7fffffff) % capacity;
	}
	
	public int size()
	{
		return number;
	}
	
	public boolean isEmpty()
	{
		return number == 0;
	}
	
	public boolean contains(K key)
	{
		return get(key) != null;
	}
	
	public V get(K key)
	{
		return buckets[hash(key)].get(key);
	}
	
	public void put(K key, V value)
	{
		if(value == null)
		{
			delete(key);
			return;
		}
		int index = hash(key);
		if(!buckets[index].contains(key))
		{
			number ++;
			if(number > capacity)
				resize(capacity * 2);
		}
		buckets[index].put(key, value);
	}
	
	public void delete(K key)
	{
		int index = hash(key);
		if( buckets[index].contains(key))
			number--;
		buckets[index].delete(key);
		if( capacity /2 >= INIT_CAPACITY && number < capacity/2)
		{
			resize(capacity/2);
		}
	}
	
	public Iterable<K> keys()
	{
		Queue<K> queue = new LinkedList<K>();
		for(int i = 0; i < buckets.length; i++)
			for(K key : buckets[i].keys())
				queue.add(key);
		return queue;
	}
}
