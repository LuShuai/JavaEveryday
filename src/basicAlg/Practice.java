package basicAlg;

public class Practice
{
	public static boolean isPalindrome(String str)
	{
		int left = 0;
		int right = str.length()-1;
		
		while(left<right)
		{
			if(str.charAt(left)!=str.charAt(right))
				return false;
			++left;
			--right;
		}
		
		return true;
	}
	
	
	public static LinkedListNode reverse(LinkedListNode head)
	{
		if(head == null)
			return null;
		LinkedListNode left, right, np;
		
		left = head;
		right = left.next;
		left.next = null;
		
		while(right!= null)
		{
			np = right.next;
			right.next = left;
			left = right;
			right = np;
		}
		return left;
	}
	
	public static LinkedListNode k2last(LinkedListNode head, int k)
	{
		if(head == null)
			return null;
		if(k<0)
			return null;
		
		
		LinkedListNode p1, p2;
		p1 = p2 = head;
		
		for(int n = 0; n < k+1; n++)
		{
			p1 = p1.next;
		}
		while(p1!=null)
		{
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
		
	}
	
	
	
	public static void main(String[] args)
	{
		if(isPalindrome("abba"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
		
		LinkedListNode head = ToolKit.genSampleLinkedListNode();
		ToolKit.printLinkedList(head);
		System.out.println(k2last(head,1).data);
		ToolKit.printLinkedList(reverse(head));
		
		
	}

}
