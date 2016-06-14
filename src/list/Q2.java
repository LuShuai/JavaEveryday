package list;

import basicAlg.LinkedListNode;
import basicAlg.ToolKit;



public class Q2
{
	public static class IntWrapper
	{
		public Integer counter = 0;
	}
	
	
	//Iterative approach
	public static LinkedListNode<Integer> k2last2(LinkedListNode<Integer> l, int k)
	{
		if(l == null)
			return null;
		if(k<0)
			return null;
		LinkedListNode<Integer> p1,p2;
		p1 = p2 = l;
		for(int n  = 0; n< k; n++)
		{
			p1 = p1.next;
			if(p1 == null)
				return null;
		}
		
		while(p1 != null)
		{
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
		
	}
	
	
	//recursive approach
	public static LinkedListNode<Integer> k2last(LinkedListNode<Integer> l, int k, IntWrapper i)
	{ 
		if(l == null)
			return null;
		LinkedListNode<Integer> node = k2last(l.next, k, i);
		i.counter ++;
		if(i.counter == k)
		{
			return l;
		}
		return node;
		
	}
	
	
	
	
	
	public static void main(String[] args)
	{
		IntWrapper iw = new IntWrapper();
		
		LinkedListNode<Integer> head = ToolKit.genSampleLinkedListNode();
		
		ToolKit.printLinkedList(head);
		
		System.out.println(k2last(head, 1, iw).data);
		if(k2last2(head, 8)!=null)
			System.out.println(k2last2(head, 8).data);
		else
			System.out.print("null");
	}

}
