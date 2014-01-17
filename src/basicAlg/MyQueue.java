package basicAlg;

public class MyQueue
{
	private static final int MAX_SIZE = 10;
	
	private int front, end, size;
	
	private int[] queue;
	
	public MyQueue()
	{
		queue = new int[MAX_SIZE];
		front = end = size = 0;
	}
	
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public boolean isFull()
	{
		return size == MAX_SIZE;
	}
	
	public void enQueue(int num)
	{
		if(this.isFull())
		{
			return ;
		}
		
		queue[end] = num;
		end = (end+1)%MAX_SIZE;
		++size;
	}
	
	public int deQueue()
	{
		if(this.isEmpty())
		{
			return Integer.MIN_VALUE;
		}
		int result = queue[front];
		front = (front+1)%MAX_SIZE;
		--size;
		return result;
	}
	

}
