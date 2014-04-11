package hashmap;

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
		pair_num = 0;
	}
	
	
	@Override
	public void put(K key, V value)
	{
		if()
		int index = hash(key);
		
		
		
	}

	private int hash(K key)
	{
		return (key.hashCode() & 0x7fffffff) % capacity;
	}
	
	@Override
	public V get(K key)
	{
		int index = hash(key);
		return buckets[index].entry.getValue();
	}

	@Override
	public void remove(Object key)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty()
	{
		return pair_num == 0;
	}
	
	@Override
	public void resize(int size)
	{
		
	}

	@Override
	public boolean contains(K key)
	{
		return get(key) != null;
	}
	
	
}
