package datastructure;

public class Tester
{

	public static void main(String[] args)
	{
		MinStack ms = new MinStack();
		ms.push(512);
		ms.push(-1024);
		ms.push(-1024);
		ms.push(512);
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
	}

}
