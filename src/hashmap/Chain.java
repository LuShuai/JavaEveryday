package hashmap;

import java.util.LinkedList;
import java.util.Queue;

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
	
	public Iterable<K> Keys()
	{
		Queue<K> q = new LinkedList<K>();
		Chain<K, V> runner = this;
		while(runner != null)
		{
			q.add(runner.entry.getKey());
			runner = runner.next;
		}
		return q;
	}
	
	public V get(K key)
	{
		Chain<K, V> runner = this;
		while(runner != null)
		{
			if(key == runner.entry.getKey())
				return runner.entry.getValue();
			runner = runner.next;
		}
		return null;
	}
}
