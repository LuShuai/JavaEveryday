package linkedList;

public class Contains
{
	
	public static boolean contains(LinkedListNode l1, LinkedListNode l2)
	{
		if(l2 == null)
			return true;
		if(l1 == null)
			return false;
		
		if(l1.val == l2.val && l2.next == null)
			return true;
		
		if(l1.val == l2.val)
			return contains(l1.next, l2.next);
		else
			return contains(l1.next, l2);
		
	}
	
	
	
	
	public static void main(String[] args)
	{
		LinkedListNode l1 = LinkedListNode.gen();
		LinkedListNode l2 = new LinkedListNode(45);
		l2.next = new LinkedListNode(2);
		l2.next.next = new LinkedListNode(4);
		
		System.out.println(contains(l1,l2));
	}

}
