package basicAlg;
public class ReverseLL
{

	/**
	 *  recursively reverse a linked list
	 */
	public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> lln)
	{
		if(lln == null) return null;
		else if(lln.next == null) return lln;
		else
		{
			LinkedListNode<Integer> sn = lln.next;
			lln.next = null;
			
			LinkedListNode<Integer> newHead = reverse(sn);
			sn.next = lln;
			return newHead;
		}
	}
	
	//Suppose the last node is 1 to last 
	public static LinkedListNode<Integer> findKtoLast(LinkedListNode<Integer> head, int k)
	{
		if(head == null)
			return null;
		LinkedListNode<Integer> p1,p2;
		p1 = head;
		p2 = head;
		for(int n  = 0; n < k; n++)
		{
			p1 = p1.next;
			if(p1 == null)
				return null;
		}
		while(p1!=null)
		{
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
	}
	
	//reverse a linked list iteratively
	public static LinkedListNode<Integer> reverse2(LinkedListNode<Integer> head)
	{
		if(head == null)
			return null;
		LinkedListNode<Integer> Left, Right, Np;
		Left = head;
		Right = Left.next;
		Left.next = null;
		
		while(Right!=null)
		{
			Np = Right.next;
			Right.next = Left;
			Left = Right;
			Right = Np;
		}
		return Left;
	}
	
	
	//just for practice
	public static LinkedListNode<Integer> reverse3(LinkedListNode<Integer> head)
	{
		if(head == null)
			return null;
		else if(head.next == null)
			return head;
		else
		{
			LinkedListNode<Integer> secondNode = head.next;
			LinkedListNode<Integer> newHead = reverse3(secondNode);
			secondNode.next = head;
			head.next = null;
			return newHead;
		}
	}
	
	
	public static void main(String[] args)
	{
		LinkedListNode<Integer> head = ToolKit.genSampleLinkedListNode();
		ToolKit.printLinkedList(head);
		
		System.out.println(findKtoLast(head,3).data);
		
		head = reverse3(head);
		ToolKit.printLinkedList(head);
	}

}
