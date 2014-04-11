package hashmap;

public class Chain<K, V>
{
	public MapEntry<K, V> entry;
	public Chain<K, V> next;
	
	public Chain()
	{
		this(null, null);
	}
	
	public Chain(MapEntry<K, V> e)
	{
		this(e, null);
	}
	
	public Chain(MapEntry<K, V> e, Chain<K, V> n)
	{
		entry = e;
		next = n;
	}
}
