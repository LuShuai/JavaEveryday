package list;

public class FunctionTest
{
	public static void turnToNull(LinkedListNode node)
	{
		node = null;
	}
	
	public static void turnToOne(LinkedListNode node)
	{
		LinkedListNode n = new LinkedListNode(1);
		node = n;
	}
	
	public static LinkedListNode insertHead(LinkedListNode node, LinkedListNode head)
	{
		head.next = node;
		return head;
	}
	
	public static void main(String[] args)
	{
		LinkedListNode node3 = new LinkedListNode(3);
		LinkedListNode node2 = new LinkedListNode(2);
		LinkedListNode node4 = new LinkedListNode(4);
		
		node3.next = node2;
		node2.next = node4;
		
		LinkedListNode.print(insertionSortList(node3));
		//LinkedListNode.print(node3 = insertHead(node3,node2));
		

	}
	
	public static LinkedListNode insertionSortList(LinkedListNode head) 
    {
        if(head == null || head.next == null)
            return head;
            
        LinkedListNode res = null;
        while(head != null)
        {
        	LinkedListNode node = head.next;
            head.next = null;
            res = insert(res, head);
            head = node;
        }
        return res;
    }
    
    //insert node into list with increasing order
    private static LinkedListNode insert(LinkedListNode list, LinkedListNode node)
    {
    	
    	System.out.println("insert:" + node.val);
        if(list == null)
            return node;
        //append in front
        if(node.val < list.val)
        {
        	node.next = list;
        	return node;
        }
        LinkedListNode head = list;
        
        while(list.next != null && list.next.val <= node.val)
        {
            list = list.next;
        }
        
        LinkedListNode temp = list.next;
        list.next = node;
        node.next = temp;
        return head;
    }
	
	

}
