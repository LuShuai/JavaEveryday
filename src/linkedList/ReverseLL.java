package linkedList;

public class ReverseLL
{
	public static LinkedListNode recursivelyR(LinkedListNode root)
	{
		if(root == null)
			return null;
		if(root.next == null)
			return root;
		LinkedListNode second = root.next;
		LinkedListNode newRoot = recursivelyR(second);
		second.next = root;
		root.next = null;
		return newRoot;
	}
	
	
	public static LinkedListNode iterativelyR(LinkedListNode root)
	{
		if(root == null)
			return null;
		if(root.next == null)
			return root;
		LinkedListNode n1 = root;
		LinkedListNode n2 = root.next; 
		LinkedListNode po = n2.next;
		n1.next = null;
		n2.next = n1;
		while(po != null)
		{
			n1 = n2;
			n2 = po;
			po = po.next;
			n2.next = n1;
		}
		return n2;
	}
	
	public static LinkedListNode reverseI(LinkedListNode node)
	{
		if(node == null)
			return null;
		if(node.next == null)
			return node;
		LinkedListNode n1 = node;
		LinkedListNode n2 = n1.next;
		LinkedListNode np = n2.next;
		
		n1.next = null;
		n2.next = n1;
		
		while(np != null)
		{
			n1 = n2;
			n2 = np;
			np = np.next;
			n2.next = n1;
		}
		return n2;
	}
	
	public static LinkedListNode reverseR(LinkedListNode node)
	{
		if(node == null)
			return null;
		if(node.next == null)
			return node;
		
		LinkedListNode second = node.next;
		LinkedListNode newNode = reverseR(second);
		second.next = node;
		node.next = null;
		return newNode;
		
	}
	
	
	
	public static void main(String[] args)
	{
		LinkedListNode.print(LinkedListNode.gen());
		LinkedListNode.print(reverseR(LinkedListNode.gen()));
	}
}
