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
	
	public static void main(String[] args)
	{
		LinkedListNode<Integer> head = ToolKit.genSampleLinkedListNode();
		ToolKit.printLinkedList(head);
		head = reverse(head);
		ToolKit.printLinkedList(head);
	}

}
