package math;

public class Fibonacci
{
	public static int fib(int n)
	{
		int a[] = new int[2];
		a[0] = a[1] = 1;
		if(n <= 0)
			return Integer.MIN_VALUE;
		if(n == 1)
			return a[0];
		if(n == 2)
			return a[1];
		// n > 2
		int counter = n - 2;
		int res = counter % 2;
		while(counter > 0)
		{
			if(counter%2 != 0)
				a[0] = a[0] + a[1];
			else
				a[1] = a[0] + a[1];
			--counter;
		}
		
		if(res == 1)
			return a[0];
		else
			return a[1];
			
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(fib(8));
	}

}
