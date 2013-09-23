package basicAlg;

import java.util.LinkedList;

public class ToolKit
{

	public static void swap(int[] a, int x, int y)
	{
		a[x] = a[x]^a[y];
		a[y] = a[x]^a[y];
		a[x] = a[x]^a[y];
	}
	public static void swap(char[] a, int x, int y)
	{
		char temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public static void printll(LinkedList<Integer> ll)
	{
		for(Integer i: ll)
		{
			System.out.print("--->["+i+"]");
		}
	}
	
	public static LinkedListNode<Integer> genSampleLinkedListNode()
	{
		LinkedListNode<Integer> head = new LinkedListNode<Integer>(3);
		head.next  = new LinkedListNode<Integer>(1);
		head.next.next = new LinkedListNode<Integer>(5);
		head.next.next.next = new LinkedListNode<Integer>(4);
		head.next.next.next.next = new LinkedListNode<Integer>(2);
		head.next.next.next.next.next = new LinkedListNode<Integer>(1);
		head.next.next.next.next.next.next = new LinkedListNode<Integer>(6);
		return head;
	}
	
	public static void printLinkedList(LinkedListNode<Integer> head)
	{
		if(head == null)
		{
			System.out.println("null");
			return;
		}
		LinkedListNode<Integer> lln = head;
		System.out.print("["+lln.data+"]");
		lln = lln.next;
		
		while(lln!=null)
		{
			System.out.print("--->["+lln.data+"]");
			lln = lln.next;
		}
		System.out.print("\n");
	}
	
	public static LinkedList<Integer> genSamplell()
	{
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(3);
		ll.add(1);
		ll.add(5);
		ll.add(4);
		ll.add(2);
		ll.add(1);
		ll.add(6);
		return ll;
	}
	
}
