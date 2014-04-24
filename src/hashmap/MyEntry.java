package hashmap;

public class MyEntry<K, V>
{
	private K key;
	private V value;
	
	public MyEntry(K k, V v)
	{
		key = k;
		value = v;
	}
	
	public K getKey()
	{
		return key;
	}
	
	public V getValue()
	{
		return value;
	}
	
	public void setKey(K k)
	{
		key = k;
	}

	public void setValue(V val)
	{
		value = val;
	}
}
