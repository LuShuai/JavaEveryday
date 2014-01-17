package someTest;
import basicAlg.LinkedListNode;

public class StringHashCode
{

	public static void main(String[] args)
	{
		String a = "123";
		String b = a;
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		
		LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(1);
		LinkedListNode<Integer> node2 = node1;
		
		System.out.println("node1:"+node1.hashCode());
		System.out.println("node2:"+node2.hashCode());
	}

}
