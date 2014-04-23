package hashmap;

import java.util.LinkedList;
import java.util.Queue;

public class Chain<K, V>
{
	class Node
	{
		private K key;
		private V value;
		private Node next;
		
		public Node(K k, V v, Node node)
		{
			key = k;
			value = v;
			next = node;
		}
	}
	
	private int N;
	private Node head;
	
	public Chain(){}
	
	public int size()
	{
		return N;
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public V get(K key)
	{
		Node runner = head;
		while(runner != null)
		{
			if(key.equals(runner.key))
				return runner.value;
			runner = runner.next;
		}
		return null;
	}
	
	public boolean contains(K key)
	{
		return get(key) != null;
	}
	
	
	
	public void put(K key, V value)
	{
		//delete
		if(value == null)
		{
			delete(key);
			return;
		}
		//change
		Node runner = head;
		while(runner != null)
		{
			if(runner.key.equals(key))
			{
				runner.value = value;
				return;
			}
		}
		//add
		head = new Node(key, value, head);
		N++;
	}
	
	public void delete(K key)
	{
		head = delete(head, key);
	}
	
	private Node delete(Node head, K key)
	{
		if(head == null)
			return null;
		if(key.equals(head.key))
		{
			N--;
			return head.next;
		}
		head.next = delete(head.next, key);
		return head;
	}
	
	public Iterable<K> keys()
	{
		Queue<K> queue = new LinkedList<K>();
		Node runner = head;
		while(runner != null)
		{
			queue.add(runner.key);
		}
		return queue;
	}

}
