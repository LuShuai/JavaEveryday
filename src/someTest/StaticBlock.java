package someTest;

public class StaticBlock
{
	static int i = 1;
	static 
	{
		i = 0;
		System.out.println("in the static block: i = " + i);
	}
	
	StaticBlock()
	{
		i = 2;
		System.out.println("in the constructor: i = " + i);
	}
	
	public static void main(String[] args)
	{
		System.out.println("github");
	}

}
