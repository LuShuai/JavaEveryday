package basicAlg;

public class Tester
{
	public static void main(String[] args)
	{
		MyQueue q = new MyQueue();
		
		q.enQueue(1);
		q.enQueue(2);
		System.out.println(q.deQueue());
		
		q.enQueue(3);
		q.enQueue(4);
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	}

}
